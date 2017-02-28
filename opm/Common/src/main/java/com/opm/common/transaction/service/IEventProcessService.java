package com.opm.common.transaction.service;

import com.opm.common.transaction.event.EventProcess;
import com.opm.common.transaction.event.EventPublish;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
public interface IEventProcessService {

    public int popFromMessageQueue(String key);

    public void invokeCallBack(EventProcess eventProcess)  throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, Exception;

    public List<EventProcess> getNewProcessEvent();

    public int updateEventPublish(EventProcess eventProcess);

    public void pocessNewEvent() throws Exception;
}
