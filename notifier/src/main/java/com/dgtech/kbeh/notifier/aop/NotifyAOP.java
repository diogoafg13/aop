package com.dgtech.kbeh.notifier.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
public class NotifyAOP {

    public NotifyAOP() {
        super();
    }

    private static Annotation[] getMethodMessage(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getAnnotations();
    }

    @Pointcut("@annotation(com.dgtech.kbeh.notifier.NotifyKBEH)")
    public void executeNotifier(){}

    @Around("executeNotifier()")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

        Annotation[] methods = getMethodMessage(joinPoint);
        long start = System.currentTimeMillis();

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

        long executionTime = System.currentTimeMillis() - start;

        return proceed;
    }

    @AfterThrowing(value = "executeNotifier()", throwing="exception")
    public void handleException(JoinPoint joinPoint, Exception exception) {
        //NotifyKBEH controller = getNotifier(joinPoint);
        //String method = getMethodName(joinPoint);
        //System.console().printf("AOP execution {}, with {} and {} ", exception, controller, method);
        //notifier.type().equals(NotifyKBEHType.NOTIFY_TYPE);
    }

}
