package com.opm.common.transaction.event;

import java.util.Date;

/**
 * Created by kfzx-liuyz1 on 2016/10/25.
 */
public class EventProcess extends EventBase {

    private EventProcessStatus eventProcessStatus;

    public EventProcess(){}

    public EventProcessStatus getEventProcessStatus() {
        return eventProcessStatus;
    }

    public void setEventProcessStatus(EventProcessStatus eventProcessStatus) {
        this.eventProcessStatus = eventProcessStatus;
    }

    private EventProcess(Builder builder){
        this.body = builder.body;
        this.createTime = new Date();
        this.eventType = builder.eventType;
        this.eventProcessStatus = builder.eventProcessStatus;
    }

    public static class Builder{

        private String body;
        private EventType eventType;
        private  EventProcessStatus eventProcessStatus;

        public Builder eventProcessStatus(EventProcessStatus eventProcessStatus){
            this.eventProcessStatus = eventProcessStatus;
            return this;
        }

        public Builder body(String body){
            this.body = body;
            return this;
        }

        public Builder eventType(EventType eventType){
            this.eventType = eventType;
            return this;
        }


        public EventProcess build(){
            return new EventProcess(this);
        }
    }

}
