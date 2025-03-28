package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RecordTimeAspect {
    @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    private void test(){};

    @Around("test()")
    public Object recordTime(ProceedingJoinPoint psj) throws Throwable {
        Long begin = System.currentTimeMillis();
        Object result = psj.proceed();
        Long end = System.currentTimeMillis();
        log.info("此方法{}执行时间为:{}ms", psj.getSignature(), end - begin
        );
        return result;
    }

    @Before("execution(* com.itheima.service.*.DeptServiceImpl.get*(..))")
    public void getTime(JoinPoint psj) {
        String methodName = psj.getSignature().getName();
        Object[] args = psj.getArgs();
        String className = psj.getClass().getName();
        log.info("methodName:{}, args:{}, className:{}",methodName, args, className);
    }
}

