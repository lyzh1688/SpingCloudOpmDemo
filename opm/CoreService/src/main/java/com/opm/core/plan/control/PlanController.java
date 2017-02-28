package com.opm.core.plan.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opm.core.plan.modle.PlanAppInfModel;
import com.opm.core.plan.modle.PlanInfoModle;
import com.opm.core.plan.service.IPlanService;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private IPlanService planService;

    @RequestMapping(value = "/getPlanBasicInfo/{planId}",method = RequestMethod.GET)
    public PlanInfoModle getPlanBasicInfo(@PathVariable String planId){
        return this.planService.getPlanBasicInfo(planId);
    }
    
    @RequestMapping(value = "/app/saves",method = RequestMethod.GET)
    public String getSavedPlans(){
    	return  "[{\"totalNum\":\"1\"},{\"appNo\":\"123\"}]";
    }
    
    /**
     * 获取计划复核申请列表
     * @return 列表信息
     */
    @RequestMapping(value = "/app/lists",method = RequestMethod.GET)
    public List<Map<String,String>> getPlans(){
    	return this.planService.getPlanApplys("", "", "");
    }
    
    /**
     * 获取计划申请明细
     * @param appNo 申请号
     * @return 申请的明细信息
     */
    @RequestMapping(value = "/app/det/{appNo}",method = RequestMethod.GET)
    public PlanAppInfModel getPlanAppDet(@PathVariable long appNo){
    	return this.planService.getPlanAppDet(appNo);
    }
}
