package com.opm.common.transaction.service.impl;

import ch.qos.logback.classic.Logger;
import com.google.gson.Gson;
import com.opm.common.redis.ConnectionPool;
import com.opm.common.transaction.contextHolder.SpringContextHolder;
import com.opm.common.transaction.dao.IEventProcessDao;
import com.opm.common.transaction.event.EventProcess;
import com.opm.common.transaction.event.EventProcessStatus;
import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.service.IEventProcessService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
@Service("EventProcessService")
public class EventProcessService implements IEventProcessService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EventProcessService.class);

    @Autowired
    private IEventProcessDao eventProcessDao;

    @Override
    @Transactional
    public int popFromMessageQueue(String key) {
        LOGGER.info("popFromMessageQueue rpop from redis...");
        Jedis jedis = ConnectionPool.getInstance().getJedis();
        String message = jedis.rpop(key);
        ConnectionPool.getInstance().returnResource(jedis);
        if(StringUtils.isEmpty(message) || message == null){
            return 0;
        }
        Gson gson = new Gson();
        EventPublish ep = gson.fromJson(message,EventPublish.class);
        EventProcess eventProcess = new EventProcess.Builder()
                .eventProcessStatus(EventProcessStatus.NEW)
                .eventType(ep.getEventType())
                .body(ep.getBody())
                .build();
        LOGGER.info("popFromMessageQueue insertEventProcess...");
        return this.eventProcessDao.insertEventProcess(eventProcess);

    }

    @Override
    public void invokeCallBack(EventProcess eventProcess) throws Exception {

        String eventTypeStr = eventProcess.getEventType().toString();
        String[] factors = eventTypeStr.split("_");
        if(factors.length != 3) {
            LOGGER.error("EventProcessService.invokeCallBack factor size if less then 3");
            throw new Exception("EventProcessService.invokeCallBack factor size if less then 3");
        }

        String serviceStr = factors[1];
        String methodStr = factors[2];
        LOGGER.info("InvokeCallBackFucntion...");
        Object bean = SpringContextHolder.getBean(serviceStr);
        Method method = bean.getClass().getDeclaredMethod(methodStr,String.class);
        method.invoke(bean,eventProcess.getBody());
    }

    @Override
    public List<EventProcess> getNewProcessEvent() {
        return this.eventProcessDao.getNewProcessEvent();
    }

    @Override
    public int updateEventPublish(EventProcess eventProcess) {
        return this.eventProcessDao.updateEventPublish(eventProcess);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pocessNewEvent() throws Exception {
        List<EventProcess> eventProcessList = this.getNewProcessEvent();
        for (EventProcess eventProcess : eventProcessList) {
            eventProcess.setEventProcessStatus(EventProcessStatus.PUBLISHED);
            int updataCnt = this.updateEventPublish(eventProcess);
            if (updataCnt > 0) {
                this.invokeCallBack(eventProcess);
            }
        }
    }

}
