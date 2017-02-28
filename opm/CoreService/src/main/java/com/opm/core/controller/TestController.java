package com.opm.core.controller;

import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.service.IEventPublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kfzx-liuyz1 on 2016/10/28.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IEventPublishService eventPublishService;

    @RequestMapping("/event")
    public List<EventPublish> getEvent(){
        return this.eventPublishService.getNewPublishEvent();
    }
}
