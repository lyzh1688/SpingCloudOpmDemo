package com.opm.voucher.order.service.impl;

import com.google.gson.Gson;
import com.opm.common.core.AppBasicInfo;
import com.opm.voucher.order.dao.IOrderDao;
import com.opm.voucher.order.entity.OrderEntity;
import com.opm.voucher.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
@Service("OrderService")
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public boolean createOrder(String orderGsonStr) {
        System.out.println("############OrderService createOrder is invoked##########3333");
        AppBasicInfo appBasicInfo = new Gson().fromJson(orderGsonStr,AppBasicInfo.class);
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAppId(appBasicInfo.getAppId());
        orderEntity.setPlanId(appBasicInfo.getPlanId());
        orderEntity.setOrderType(appBasicInfo.getOrderType());
        orderEntity.setCoPlanFlag("a");
        orderEntity.setUpdateTime(new Date());
        orderEntity.setValidFlag(true);
        int resCnt = this.orderDao.insertOrder(orderEntity);
        return resCnt == 1 ? true : false;
    }

}
