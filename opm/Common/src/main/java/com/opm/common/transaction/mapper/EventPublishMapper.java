package com.opm.common.transaction.mapper;

import com.opm.common.transaction.event.EventPublish;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
public interface EventPublishMapper {

    @Insert("INSERT INTO OPM_EVENT_PUBLISH(EVENT_ID,EVENT_STATUS,EVENT_TYPE,EVENT_BODY,UPDATE_TIME) VALUES(#{EVENT_ID},#{EVENT_STATUS},#{EVENT_TYPE},#{EVENT_BODY},#{UPDATE_TIME}) ")
    @SelectKey(statement = "SELECT SEQ_EVENT_PUBLISH.nextval FROM dual", keyProperty = "EVENT_ID", before = true, resultType = int.class)
    public int insertEventPublish(@Param("EVENT_STATUS") String eventStatus, @Param("EVENT_TYPE")  String eventType, @Param("EVENT_BODY") String eventBody, @Param("UPDATE_TIME")Date date);

    @Select("SELECT * from OPM_EVENT_PUBLISH WHERE event_status = 'NEW'")
    @Results({
            @Result(id = true,column = "EVENT_ID",property = "id"),
            @Result(column = "EVENT_STATUS",property = "eventPublishStatus",typeHandler = com.opm.common.typehandler.EventPublishStatusHandler.class),
            @Result(column = "EVENT_TYPE",property = "eventType",typeHandler = com.opm.common.typehandler.EventTypeHandler.class),
            @Result(column = "EVENT_BODY",property = "body"),
            @Result(column = "UPDATE_TIME",property = "createTime")
    })
    public List<EventPublish> getNewEvent();

    @Update("UPDATE OPM_EVENT_PUBLISH SET EVENT_STATUS = #{EVENT_STATUS} WHERE EVENT_ID = #{EVENT_ID} AND EVENT_STATUS = 'NEW'")
    public int updateEventPublish(@Param("EVENT_ID") String id, @Param("EVENT_STATUS")  String eventStatus);
}
