package com.opm.common.transaction.dao.impl;

import com.opm.common.transaction.dao.IEventPublishDao;
import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.mapper.EventPublishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
@Repository
public class EventPublishDao implements IEventPublishDao {
    @Autowired
    private EventPublishMapper eventPublishMapper;

    @Override
    public int insertEventPublish(EventPublish eventPublish) {
        return this.eventPublishMapper.insertEventPublish(eventPublish.getEventPublishStatus().toString(),
                                                              eventPublish.getEventType().toString(),
                                                              eventPublish.getBody(),
                                                              eventPublish.getCreateTime());
    }

    @Override
    public List<EventPublish> getNewPublishEvent() {
        return this.eventPublishMapper.getNewEvent();
    }

    @Override
    public int updateEventPublish(EventPublish eventPublish) {
        return this.eventPublishMapper.updateEventPublish(eventPublish.getId(),eventPublish.getEventPublishStatus().toString());
    }
}
