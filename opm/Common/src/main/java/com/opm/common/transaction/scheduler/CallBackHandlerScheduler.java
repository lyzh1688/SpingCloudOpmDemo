package com.opm.common.transaction.scheduler;

import ch.qos.logback.classic.Logger;
import com.opm.common.transaction.service.IEventProcessService;
import com.opm.common.transaction.service.impl.EventProcessService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by kfzx-liuyz1 on 2016/10/30.
 */
@Component
public class CallBackHandlerScheduler {

    private final int delay = 0;

    private final int inteval = 1;

    private final TimeUnit timeUnit = TimeUnit.SECONDS;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CallBackHandlerScheduler.class);

    @Autowired
    private IEventProcessService eventProcessService;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public CallBackHandlerScheduler(){
        scheduledExecutorService.scheduleAtFixedRate(new CallBackHandlerRunnable(),this.delay,this.inteval,this.timeUnit);
    }

    private class CallBackHandlerRunnable implements Runnable{

        @Override
        public void run() {
            try {
                if(eventProcessService != null){
                    eventProcessService.pocessNewEvent();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
