package com.opm.common.typehandler;

import com.opm.common.transaction.event.EventPublishStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kfzx-liuyz1 on 2016/10/27.
 */
public class EventPublishStatusHandler extends BaseTypeHandler<EventPublishStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EventPublishStatus eventPublishStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(eventPublishStatus.toString()));
    }

    @Override
    public EventPublishStatus getNullableResult(ResultSet resultSet, String columnName) throws SQLException {

        String eventPublishStatus = resultSet.getString(columnName);

        if(eventPublishStatus != null){

            return EventPublishStatus.valueOf(eventPublishStatus);
        }

        return null;
    }

    @Override
    public EventPublishStatus getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {

        String eventPublishStatus = resultSet.getString(columnIndex);

        if(eventPublishStatus != null){

            return EventPublishStatus.valueOf(eventPublishStatus);
        }

        return null;
    }

    @Override
    public EventPublishStatus getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {

        String eventPublishStatus = callableStatement.getString(columnIndex);

        if(eventPublishStatus != null){

            return EventPublishStatus.valueOf(eventPublishStatus);
        }

        return null;
    }
}
