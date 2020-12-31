package com.xishan.store.usercenter.userweb.aop;

import com.alibaba.fastjson.JSON;
import com.xishan.store.usercenter.userapi.context.UserContext;
import com.xishan.store.usercenter.userapi.dto.UserDTO;
import com.xishan.store.usercenter.userapi.model.response.UserLoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.RpcContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
@Order(3)
public class UserContextAop {

    @Pointcut("execution(public * com.xishan.store.usercenter.userweb.controller.*.*(..))")
    private void userContextAspect() {
    }

    @Around("userContextAspect()")
    public Object webContextAround(ProceedingJoinPoint point){
        //执行前，塞进UserContext中，执行后清除UserContext
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserDTO user = null;
        if( request.getSession().getAttribute("user") != null){
            user = (UserDTO) request.getSession().getAttribute("user");
        }
        if(user != null){
            UserContext.putCurrentUser(user);
            RpcContext.getContext().setAttachment("user",user);
        }
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        UserContext.clearCurrentUser();
        RpcContext.getContext().removeAttachment("user");

        return result;
        //执行目标
    }
}
