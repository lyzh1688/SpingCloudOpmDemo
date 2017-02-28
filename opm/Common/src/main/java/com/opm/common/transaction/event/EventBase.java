package com.opm.common.transaction.event;

import java.util.Date;

/**
 * Created by kfzx-liuyz1 on 2016/10/25.
 */
public class EventBase {

    protected String id;
    protected String body;
    protected Date createTime;
    protected EventType eventType;

    public void setId(String id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public EventType getEventType() {
        return eventType;
    }

}
