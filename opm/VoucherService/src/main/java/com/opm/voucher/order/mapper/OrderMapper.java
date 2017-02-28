package com.opm.voucher.order.mapper;

import com.opm.voucher.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
public interface OrderMapper {
    public int insertOrder(@Param("planId")String planId,
                           @Param("orderType")String orderType,
                           @Param("appId")long appId,
                           @Param("coPlanFlag")String coPlanFlag,
                           @Param("updateTime")Date updateTime,
                           @Param("validFlag") int validFlag);
}
