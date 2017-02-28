package com.opm.common.transaction.event;

import java.util.Date;

/**
 * Created by kfzx-liuyz1 on 2016/10/25.
 */
public class EventPublish extends EventBase {

    private EventPublishStatus eventPublishStatus;

    public EventPublish(){

    }

    public EventPublishStatus getEventPublishStatus() {
        return eventPublishStatus;
    }

    public void setEventPublishStatus(EventPublishStatus eventPublishStatus) {
        this.eventPublishStatus = eventPublishStatus;
    }

    private EventPublish(Builder builder){
        this.body = builder.body;
        this.createTime = new Date();
        this.eventType = builder.eventType;
        this.eventPublishStatus = builder.eventPublishStatus;
    }

    public static class Builder{

        private String body;
        private EventType eventType;
        private EventPublishStatus eventPublishStatus;

        public Builder eventProcessStatus(EventPublishStatus eventPublishStatus){
            this.eventPublishStatus = eventPublishStatus;
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

        public EventPublish build(){
            return new EventPublish(this);
        }

    }
}
