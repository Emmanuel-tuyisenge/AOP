package com.manu.aopdemo.aspect;

import java.util.List;

import com.manu.aopdemo.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AterReturning on the findAccount method
    @AfterReturning(
        pointcut = "execution(* com.manu.aopdemo.dao.AccountDAO.findAccount(..))",
        returning = "result")
    public void afterReturningFindAccountsAdvice(
        JoinPoint theJoinPoint, List<Account> result) {

            // print out which method we are advising on
            String method = theJoinPoint.getSignature().toShortString();
            System.out.println("\n=====>>> Executing @AfeterReturning on method: "+ method);

            // print out the results of the method call
            System.out.println("\n====>>> results is: " + result);
    }

    //@Before("execution(public void add*())")
    //@Before("execution(* add*(com.manu.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* com.manu.aopdemo.dao.*.*(..))")
    //@Before("forDAOPackage()")
    @Before("com.manu.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n====>>> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+ methoSig);

        // display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }

}
