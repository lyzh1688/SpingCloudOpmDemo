package com.opm.common.typehandler;

import com.opm.common.transaction.event.EventProcessStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by kfzx-liuyz1 on 2016/10/30.
 */
public class EventProcessStatusHandler  extends BaseTypeHandler<EventProcessStatus> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, EventProcessStatus eventProcessStatus, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, String.valueOf(eventProcessStatus.toString()));

    }

    @Override
    public EventProcessStatus getNullableResult(ResultSet resultSet, String columnName) throws SQLException {

        String eventProcessStatus = resultSet.getString(columnName);

        if(eventProcessStatus != null){

            return EventProcessStatus.valueOf(eventProcessStatus);
        }

        return null;
    }

    @Override
    public EventProcessStatus getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {

        String eventProcessStatus = resultSet.getString(columnIndex);

        if(eventProcessStatus != null){

            return EventProcessStatus.valueOf(eventProcessStatus);
        }

        return null;
    }

    @Override
    public EventProcessStatus getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {

        String eventProcessStatus = callableStatement.getString(columnIndex);

        if(eventProcessStatus != null){

            return EventProcessStatus.valueOf(eventProcessStatus);
        }

        return null;
    }
}
