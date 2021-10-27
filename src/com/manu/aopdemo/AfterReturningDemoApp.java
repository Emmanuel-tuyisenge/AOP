package com.manu.aopdemo;

import java.util.List;

import com.manu.aopdemo.dao.AccountDAO;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call methode to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccount();

        // display the accounts
        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");

        System.out.println(theAccounts);

        System.out.println("\n");

        // close the context
        context.close();
    }
}
