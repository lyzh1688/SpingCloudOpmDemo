package com.opm.voucher.controller;

import com.opm.voucher.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /*
    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/createOrder",method = RequestMethod.POST)
    public boolean createOrder(){
        return this.orderService.createOrder();
    }
    */
}
