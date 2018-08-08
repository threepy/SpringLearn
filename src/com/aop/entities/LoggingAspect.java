package com.aop.entities;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
    public void pointCut() {

    }

    public void doBefore(JoinPoint joinPoint) {
        System.out.println("aop before advice");
    }

    public void doAfter(JoinPoint joinPoint) {
        System.out.println("aop after advice");
    }

    public void afterReturn(JoinPoint joinPoint, Object returnVal) {
        System.out.println("aop afterReturning advice: " + returnVal);
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("aop afterThrowing advice: " + error);
        System.out.println("afterThrowing");
    }

    public Object around(ProceedingJoinPoint pjp) {
        Object result = null;
        String methodName = pjp.getSignature().getName();
        System.out.println("aop arround before");
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("aop around after.");
        return result;
    }
}
