package com.manu.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach(){
        System.out.println("--> TennisCoach: inside default constructor");
    }
    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("--> TennisCoach: inside of doMyStartupStuff" );
    }

    // define my init method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("--> TennisCoach: inside of doMyCleanupStuff" );
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backend valley";
    }
    @Override
    public String getDailyFortune() {
        return "The best journey ever!";
    }

}
