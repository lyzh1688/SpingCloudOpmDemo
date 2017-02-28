package com.opm.common.aspect;

import com.google.gson.Gson;
import com.opm.common.aspect.anno.FinalConst;
import com.opm.common.transaction.dao.IEventPublishDao;
import com.opm.common.transaction.event.EventPublish;
import com.opm.common.transaction.event.EventPublishStatus;
import com.opm.common.transaction.event.EventType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * Created by kfzx-liuyz1 on 2016/10/25.
 */
@Aspect
@Configuration("FinalConstAspect")
public class FinalConstAspect {

    @Autowired
    private IEventPublishDao eventPublishDao;

    @Pointcut("@annotation(com.opm.common.aspect.anno.FinalConst)")
    public void FinalConstAspect() {
        System.out.println("=====FinalConstAspect=====");

    }

    @Before("FinalConstAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("=====前置通知开始=====");
    }

    @After("FinalConstAspect()")
    public void doAfter(JoinPoint joinPoint){

        System.out.println("=====后置通知=====");

    }

    @AfterReturning(pointcut = "FinalConstAspect()", returning = "resultStr")
    public void doAfterReturning(JoinPoint joinPoint,String resultStr) throws Exception {
        System.out.println("=====获取返回值,后置通知=====");
        if(resultStr != null){
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            FinalConst finalConstAnno = method.getDeclaredAnnotation(FinalConst.class);

            for(String eventTypeStr : finalConstAnno.events()){
                EventPublish eventPublish = new EventPublish.Builder()
                        .eventProcessStatus(EventPublishStatus.NEW)
                        .eventType(EventType.valueOf(eventTypeStr))
                        .body(resultStr)
                        .build();
                this.eventPublishDao.insertEventPublish(eventPublish);

            }
        }
    }

    @AfterThrowing(pointcut = "FinalConstAspect()", throwing = "e")
    public void doAfterThrowing(Exception e) {
        System.out.println("=====例外通知=====");
        System.out.println(e.getMessage());
    }
}
