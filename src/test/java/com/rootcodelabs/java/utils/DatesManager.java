package com.rootcodelabs.java.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DatesManager {

    public static String getCurrentDate(){
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return formattedDate;
    }

    public static String getRandomFutureDate() {
        Faker faker = new Faker();
        String randomFutureDate = String.valueOf(faker.date().future(1, TimeUnit.DAYS));
        return randomFutureDate;
    }

    public static String getRandomPastDate() {
        Faker faker = new Faker();
        String randomPastDate = String.valueOf(faker.date().past(1, TimeUnit.DAYS));
        return randomPastDate;
    }
}
