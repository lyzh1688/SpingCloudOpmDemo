package com.opm.common.transaction.dao;

import com.opm.common.transaction.event.EventProcess;
import com.opm.common.transaction.event.EventPublish;

import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
public interface IEventProcessDao {

    public int insertEventProcess(EventProcess eventProcess);

    public List<EventProcess> getNewProcessEvent();

    public int updateEventPublish(EventProcess eventProcess);
}
