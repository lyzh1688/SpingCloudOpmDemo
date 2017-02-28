package com.opm.common.aspect.anno;

import java.lang.annotation.*;

/**
 * Created by kfzx-liuyz1 on 2016/10/25.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FinalConst {
    String[] events() default {};
}
