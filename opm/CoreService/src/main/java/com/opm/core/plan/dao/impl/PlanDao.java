package com.opm.core.plan.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.opm.core.plan.dao.IPlanDao;
import com.opm.core.plan.mapper.PlanMapper;
import com.opm.core.plan.modle.PlanAppInfModel;
import com.opm.core.workflow.modle.ApplicationModle;

@Repository("PlanDao")
public class PlanDao implements IPlanDao {
	@Autowired
	private PlanMapper planMapper;

	@Override
	public PlanAppInfModel getPlanAppDet(long appNo) {
		return this.planMapper.getPlanAppDet(appNo);
	}
	
	@Override
	public List<ApplicationModle> getPlanApplys(String branchId, String userId, String roleId) {
		return this.planMapper.getPlanApplys(branchId, userId, roleId);
	}
}
