package com.opm.core.common.enumdict;

/**
 * Created by kfzx-liuyz1 on 2016/10/24.
 */
public enum ReviewType {

    Agree("同意"),
    Save("保存"),
    Review("待审核");

    private String desc;
    private ReviewType(String desc){
        this.desc = desc;
    }
}
