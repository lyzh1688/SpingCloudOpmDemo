package com.opm.core.plan.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opm.core.plan.dao.impl.PlanDao;
import com.opm.core.plan.modle.PlanAppInfModel;
import com.opm.core.plan.modle.PlanInfoModle;
import com.opm.core.plan.service.IPlanService;
import com.opm.core.workflow.modle.ApplicationModle;

import ch.qos.logback.classic.Logger;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
@Service("PlanService")
public class PlanService implements IPlanService {

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PlanService.class);

	@Autowired
	private PlanDao dao;

	@Override
	public PlanInfoModle getPlanBasicInfo(String planId) {
		LOGGER.warn("getPlanBasicInfo");
		return new PlanInfoModle();
	}

	@Override
	public List<Map<String, String>> getPlanApplys(String branchId, String userId, String roleId) {
		List<Map<String, String>> ls = new ArrayList<Map<String, String>>();
		List<ApplicationModle> list = this.dao.getPlanApplys(branchId, userId, roleId);
		for (ApplicationModle apply : list) {
			Map<String, String> t = new HashMap<String, String>();
			t.put("appNo", apply.getApplyId());
			t.put("planName", apply.getPlanName());
			t.put("appUser", apply.getApplyUser());
			t.put("appType", apply.getApplyType().getDescription());
			t.put("appState", apply.getApplyStatus().getDescription());
			t.put("appTime", new SimpleDateFormat("yyyy-MM-dd hhmmss").format(apply.getApplyTime()));

			ls.add(t);
		}
		return ls;
	}

	/**
	 * 获取申请明细信息
	 * 
	 * @param appNo
	 *            申请号
	 * @return 申请明细信息
	 */
	@Override
	public PlanAppInfModel getPlanAppDet(long appNo) {
		return this.dao.getPlanAppDet(appNo);
	}
}
