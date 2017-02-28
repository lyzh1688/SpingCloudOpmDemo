package com.opm.common.transaction.service.impl;

import ch.qos.logback.classic.Logger;
import com.google.gson.Gson;
import com.opm.common.redis.ConnectionPool;
import com.opm.common.transaction.dao.IEventPublishDao;
import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.event.EventPublishStatus;
import com.opm.common.transaction.service.IEventPublishService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
@Service
public class EventPublishService implements IEventPublishService{

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EventPublishService.class);
    private final String msgQueuePrefix = "MQ:";
    @Autowired
    private IEventPublishDao eventPublishDao;

    @Override
    public int insertEventPublish(EventPublish eventPublish) {
        LOGGER.info("insertEventPublish");
        return this.eventPublishDao.insertEventPublish(eventPublish);
    }

    @Override
    public List<EventPublish> getNewPublishEvent() {
        LOGGER.info("getNewPublishEvent");
        return this.eventPublishDao.getNewPublishEvent();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pushToMessageQueue(EventPublish eventPublish) {

        eventPublish.setEventPublishStatus(EventPublishStatus.PUBLISHED);
        int updateCnt = this.eventPublishDao.updateEventPublish(eventPublish);
        if(updateCnt > 0){
            String messageQueue = eventPublish.getEventType().toString().split("_")[0];
            String key = this.msgQueuePrefix + messageQueue;
            Jedis jedis = ConnectionPool.getInstance().getJedis();
            jedis.lpush(key,new Gson().toJson(eventPublish));
            ConnectionPool.getInstance().returnResource(jedis);
        }

    }
}
