package com.opm.core.plan.dao;

import java.util.List;

import com.opm.core.plan.modle.PlanAppInfModel;
import com.opm.core.workflow.modle.ApplicationModle;

public interface IPlanDao {
	public List<ApplicationModle> getPlanApplys(String branchId, String userId, String roleId);

	/**
	 * 获取计划申请信息
	 * 
	 * @param appNo
	 *            申请号
	 * @return
	 */
	public PlanAppInfModel getPlanAppDet(long appNo);
}
