package com.dgtech.kbeh.notifier.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
public class NotifyAOP {

    public NotifyAOP() {
        super();
    }

    @Around("@annotation(NotifyKBEH)")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    /*
    @Pointcut("execution (public * *(..))")
    private void handleAnyException(){
        //do nothing
    }

    @AfterThrowing(value = "handleAnyException()", throwing="exception")
    public void handleNotifier(JoinPoint joinPoint, Exception exception){
        NotifyKBEH controller = getNotifier(joinPoint);
        String method = getMethodName(joinPoint);
        System.console().printf("AOP execution {}, with {} and {} ", exception, controller, method);
        //notifier.type().equals(NotifyKBEHType.NOTIFY_TYPE);
    }

    private NotifyKBEH getNotifier(JoinPoint joinPoint){
        return (NotifyKBEH) joinPoint.getTarget();
    }

    private String getMethodName(JoinPoint joinPoint){
        return joinPoint.getSignature().getName();
    }*/
}
