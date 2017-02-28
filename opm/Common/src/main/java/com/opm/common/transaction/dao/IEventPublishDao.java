package com.opm.common.transaction.dao;

import com.opm.common.transaction.event.EventPublish;
import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
public interface IEventPublishDao {

    public int insertEventPublish(EventPublish eventPublish);

    public List<EventPublish> getNewPublishEvent();

    public int updateEventPublish(EventPublish eventPublish);
}
