package com.xishan.store.usercenter.userserver.aop;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
//申明是个spring管理的bean
@Component
@Order(1)
@Slf4j
public class LogAspect {

    private Gson gson = new Gson();

    //申明一个切点 里面是 execution表达式

    @Pointcut("execution(public * com.xishan.store.usercenter.userserver.facade.*.*(..))")
    private void controllerAspect() {
    }

      @Around("controllerAspect()")
    public Object serviceLogAround(ProceedingJoinPoint point){
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Object result = point.proceed();
            stopWatch.stop();
            log.info("class:{},method:{},args:{},runTime:{},result:{}",className,methodName, handlerParameter(point),stopWatch.getTotalTimeMillis(), JSON.toJSONString(result));
            return result;
        } catch (RuntimeException e){
            e.printStackTrace();
            return "系统异常";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "系统异常";
        }
    }

    private String handlerParameter(ProceedingJoinPoint point){
        StringBuilder stringBuilder = new StringBuilder();
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();
        Object[] args = point.getArgs();
        int i=0;
        for (Object pojo : args){
            stringBuilder.append("parameterName:").append(parameterNames[i]);
            stringBuilder.append("parameterType:").append(parameterTypes[i]);
            stringBuilder.append("parameterValue:").append(pojo);
        }
        return stringBuilder.toString();
    }


    //在方法执行完结后打印返回内容

}