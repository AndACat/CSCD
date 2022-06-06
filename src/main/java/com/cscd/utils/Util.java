package com.cscd.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Util {
    public String getRandomUid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getRandomString(){
        return getRandomUid().substring(1, 5).toLowerCase();
    }

}
