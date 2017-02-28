package com.opm.core.plan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.opm.core.plan.modle.PlanAppInfModel;
import com.opm.core.workflow.modle.ApplicationModle;

@Mapper
public interface PlanMapper {
	/**
	 * 获取计划申请信息
	 * 
	 * @param appNo
	 *            申请号
	 * @return 申请的情况
	 */
	public PlanAppInfModel getPlanAppDet(@Param("appNo") long appNo);

	/**
	 * 获取计划申请列表
	 * 
	 * @param branchId
	 *            机构编码
	 * @param userId
	 *            用户编码
	 * @param roleId
	 *            角色编码
	 * @return 列表
	 */
	public List<ApplicationModle> getPlanApplys(@Param("branchId") String branchId, 
												@Param("userId") String userId, 
												@Param("roleId") String roleId);
}
