package com.opm.common.transaction.dao.impl;

import com.opm.common.transaction.dao.IEventProcessDao;
import com.opm.common.transaction.event.EventProcess;
import com.opm.common.transaction.mapper.EventProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
@Repository
public class EventProcessDao implements IEventProcessDao {

    @Autowired
    private EventProcessMapper eventProcessMapper;

    @Override
    public int insertEventProcess(EventProcess eventProcess) {
        return this.eventProcessMapper.insertEventProcess(eventProcess.getEventProcessStatus().toString(),eventProcess.getEventType().toString(),eventProcess.getBody(),eventProcess.getCreateTime());
    }

    @Override
    public List<EventProcess> getNewProcessEvent() {
        return this.eventProcessMapper.getNewEvent();
    }

    @Override
    public int updateEventPublish(EventProcess eventProcess) {
        return this.eventProcessMapper.updateEventProcess(eventProcess.getId(),eventProcess.getEventProcessStatus().toString());
    }
}
