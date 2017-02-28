package com.opm.common.transaction.mapper;

import com.opm.common.transaction.event.EventProcess;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
public interface EventProcessMapper {

    @Insert("INSERT INTO OPM_EVENT_PROCESS(EVENT_ID,EVENT_STATUS,EVENT_TYPE,EVENT_BODY,UPDATE_TIME) VALUES(#{EVENT_ID},#{EVENT_STATUS},#{EVENT_TYPE},#{EVENT_BODY},#{UPDATE_TIME}) ")
    @SelectKey(statement = "SELECT SEQ_EVENT_PROCESS.nextval FROM dual", keyProperty = "EVENT_ID", before = true, resultType = int.class)
    public int insertEventProcess(@Param("EVENT_STATUS") String eventStatus, @Param("EVENT_TYPE")  String eventType, @Param("EVENT_BODY") String eventBody, @Param("UPDATE_TIME")Date date);

    @Update("UPDATE OPM_EVENT_PROCESS SET EVENT_STATUS = #{EVENT_STATUS} WHERE EVENT_ID = #{EVENT_ID} AND EVENT_STATUS = 'NEW'")
    public int updateEventProcess(@Param("EVENT_ID") String id, @Param("EVENT_STATUS")  String eventStatus);

    @Select("SELECT * from OPM_EVENT_PROCESS WHERE event_status = 'NEW'")
    @Results({
            @Result(id = true,column = "EVENT_ID",property = "id"),
            @Result(column = "EVENT_STATUS",property = "eventProcessStatus",typeHandler = com.opm.common.typehandler.EventProcessStatusHandler.class),
            @Result(column = "EVENT_TYPE",property = "eventType",typeHandler = com.opm.common.typehandler.EventTypeHandler.class),
            @Result(column = "EVENT_BODY",property = "body"),
            @Result(column = "UPDATE_TIME",property = "createTime")
    })
    public List<EventProcess> getNewEvent();
}
