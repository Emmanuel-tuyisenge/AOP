package com.manu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

     //@Before("forDAOPackage()")
     @Before("com.manu.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
     public void performApiAnalytics() {
         System.out.println("\n====>>> Performing API analytics");
     }
}
