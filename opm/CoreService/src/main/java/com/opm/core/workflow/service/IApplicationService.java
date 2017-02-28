package com.opm.core.workflow.service;

import com.opm.common.enumDict.ApplyStatus;
import com.opm.common.transaction.event.EventPublish;
import com.opm.core.workflow.modle.ApplicationModle;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
public interface IApplicationService {
    public ApplicationModle getPlanApplicationList(String planId, int page, int rownum , ApplyStatus... applyStatus);
    public String applyReview(String applyId, String result);
}
