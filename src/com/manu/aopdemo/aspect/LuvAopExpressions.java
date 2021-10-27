package com.manu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* com.manu.aopdemo.dao.*.*(..))")
    private void forDAOPackage(){

    }

    //  create pointcut for getter methods
    @Pointcut("execution(* com.manu.aopdemo.dao.*.get*(..))")
    private void getter() {}

    //  create pointcut for setter methods
    @Pointcut("execution(* com.manu.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDAOPackage() && !(getter() || setter() )")
    public void forDAOPackageNoGetterSetter() {}
}
