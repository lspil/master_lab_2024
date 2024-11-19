package org.acme.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ObserveAspect {

    @Around("@annotation(org.acme.aspects.Observe)")
    public void observe(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName() + " is being observed");

        joinPoint.proceed();
    }

    @Before("@annotation(org.acme.aspects.Observe)")
    public void before(JoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint.getSignature().getName() + " is being observed");
    }
}
