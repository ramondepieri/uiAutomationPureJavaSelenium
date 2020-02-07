package com.hellofresh.challenge.core.utils;

import java.util.Date;

public class RandomDataGenerator {

    public static String getCurrentDateTime(){
        String timestamp = String.valueOf(new Date().getTime());
        return timestamp;
    }

    public static String getRandomEmail(){
        String timestamp = getCurrentDateTime();
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        return email;
    }

}
