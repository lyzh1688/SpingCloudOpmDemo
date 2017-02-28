package com.opm.common.transaction.service;

import com.opm.common.transaction.event.EventPublish;

import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
public interface IEventPublishService {
    public int insertEventPublish(EventPublish eventPublish);
    public List<EventPublish> getNewPublishEvent();
    public void pushToMessageQueue(EventPublish eventPublish);
}
