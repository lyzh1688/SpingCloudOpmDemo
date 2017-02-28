package com.opm.voucher.order.dao.impl;

import com.opm.voucher.order.dao.IOrderDao;
import com.opm.voucher.order.entity.OrderEntity;
import com.opm.voucher.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by kfzx-liuyz1 on 2016/10/31.
 */
@Repository
public class OrderDao implements IOrderDao {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int insertOrder(OrderEntity order) {
        return this.orderMapper.insertOrder(order.getPlanId(),
                order.getOrderType().toString(),
                order.getAppId(),
                order.getCoPlanFlag(),
                order.getUpdateTime(),
                order.isValidFlag() == true ? 1:0
                );
    }
}
