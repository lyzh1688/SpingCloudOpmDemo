package com.opm.common.transaction.scheduler;

import ch.qos.logback.classic.Logger;
import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.service.IEventPublishService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
@Component
public class EventPublishScheduler {

    private final int delay = 0;

    private final int inteval = 5;

    private final TimeUnit timeUnit = TimeUnit.SECONDS;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EventPublishScheduler.class);

    @Autowired
    private IEventPublishService eventPublishService;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public EventPublishScheduler(){
        scheduledExecutorService.scheduleAtFixedRate(new EventPublishRunnable(),this.delay,this.inteval,this.timeUnit);
    }

    private class EventPublishRunnable implements Runnable{

        @Override
        public void run() {
            try{
                LOGGER.info("EventPublishRunnable");
                if(eventPublishService != null){
                    List<EventPublish> eventPublishList = eventPublishService.getNewPublishEvent();
                    LOGGER.info("EventPublish Count : " + eventPublishList.size());
                    if(eventPublishList != null){
                        eventPublishList.forEach(eventPublish -> eventPublishService.pushToMessageQueue(eventPublish));
                    }
                }
            }
            catch (Exception e){
                LOGGER.error(e.toString());
            }

        }
    }
}
