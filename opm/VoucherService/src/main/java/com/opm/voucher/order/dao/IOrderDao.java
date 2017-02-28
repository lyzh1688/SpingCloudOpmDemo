package com.opm.voucher.order.dao;

import com.opm.voucher.order.entity.OrderEntity;

/**
 * Created by kfzx-liuyz1 on 2016/10/31.
 */
public interface IOrderDao {
    public int insertOrder(OrderEntity order);
}
