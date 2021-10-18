package com.manu.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        //read spring config file
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if they are the same
        boolean result = (theCoach == alphaCoach);

        // call a method on the bean
        System.out.println("\n Pointing to the same object: " + result);
        System.out.println("\n Memory location for theCoach: " + theCoach);
        System.out.println("\n Memory location for alphaCoach: " + alphaCoach + "\n");

        // close the context
        context.close();
    }
}
