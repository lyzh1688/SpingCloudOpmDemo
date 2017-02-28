package com.opm.core.plan.service;

import java.util.List;
import java.util.Map;

import com.opm.core.plan.modle.PlanAppInfModel;
import com.opm.core.plan.modle.PlanInfoModle;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
public interface IPlanService {
	public PlanInfoModle getPlanBasicInfo(String planId);

	/**
	 * 获取待复核的申请列表
	 * @param branchId 机构编码
	 * @param userId 用户编码
	 * @param roleId 角色编码
	 * @return 申请列表
	 */
	public List<Map<String,String>> getPlanApplys(String branchId, String userId, String roleId);
	
	/**
	 * 获取申请明细信息
	 * @param appNo 申请号
	 * @return 申请明细信息
	 */
	public PlanAppInfModel getPlanAppDet(long appNo);
}
