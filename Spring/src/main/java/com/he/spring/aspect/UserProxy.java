package com.he.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
    @Before("execution(* com.he.spring.service.impl.UserServiceImpl.add(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("before....");
    }
}
