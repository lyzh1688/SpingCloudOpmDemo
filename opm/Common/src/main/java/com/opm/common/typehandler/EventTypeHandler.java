package com.opm.common.typehandler;

import com.opm.common.transaction.event.EventType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
public class EventTypeHandler extends BaseTypeHandler<EventType> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EventType eventType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(eventType.toString()));
    }

    @Override
    public EventType getNullableResult(ResultSet resultSet, String columnName) throws SQLException {

        String eventType = resultSet.getString(columnName);

        if(eventType != null){

            return EventType.valueOf(eventType);
        }
        return null;
    }

    @Override
    public EventType getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String eventType = resultSet.getString(columnIndex);

        if(eventType != null){

            return EventType.valueOf(eventType);
        }
        return null;
    }

    @Override
    public EventType getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {

        String eventType = callableStatement.getString(columnIndex);

        if(eventType != null){

            return EventType.valueOf(eventType);
        }
        return null;
    }
}
