package com.manu.springdemo;

public class SadFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Togay is a sad day";
    }

}
