package com.example.demo.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
public class TestAspect {


    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.example.demo.aop.TestAnnotation)")
    private void cut() {
        // do nothing
    }

    /**
     * 环绕通知
     */
    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("come in");
        return joinPoint.proceed();
    }
}
