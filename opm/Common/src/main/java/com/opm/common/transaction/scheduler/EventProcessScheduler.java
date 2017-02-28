package com.opm.common.transaction.scheduler;

import ch.qos.logback.classic.Logger;
import com.opm.common.conf.AppInfo;
import com.opm.common.redis.ConnectionPool;
import com.opm.common.transaction.event.EventProcess;
import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.service.IEventProcessService;
import com.opm.common.transaction.service.IEventPublishService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
@Component
public class EventProcessScheduler {

    private final int delay = 0;

    private final int inteval = 1;

    private final TimeUnit timeUnit = TimeUnit.SECONDS;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EventProcessScheduler.class);

    @Autowired
    private IEventProcessService eventProcessService;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public EventProcessScheduler(){
        scheduledExecutorService.scheduleAtFixedRate(new EventProcessRunnable(),this.delay,this.inteval,this.timeUnit);
    }

    private class EventProcessRunnable implements Runnable{

        private final String msgQueuePrefix = "MQ:";

        @Override
        public void run() {
            try{
                LOGGER.info("EventProcessRunnable");
                if(AppInfo.getInstance().getAppServiceEnum() != null && eventProcessService != null){
                    int cnt = eventProcessService.popFromMessageQueue(msgQueuePrefix + AppInfo.getInstance().getAppServiceEnum().toString());
                    LOGGER.info("EventProcess Count : " + cnt);
                }

                //eventProcessService.insertEventProcess()
                //List<EventPublish> eventPublishList = eventPublishService.getNewEvent();
                //LOGGER.info("EventPublish Count : " + eventPublishList.size());
                //eventPublishList.forEach(eventPublish -> eventPublishService.pushToMessageQueue(eventPublish));
            }
            catch (Exception e){
                LOGGER.error(e.toString());
            }

        }
    }
}
