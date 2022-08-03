package com.rootcodelabs.java.utils;

public class DatesTester {

    public static void main(String[] args) {

        String currentDate = DatesManager.getCurrentDate();
        System.out.println("Current Date : " + currentDate);

        String futureDate = DatesManager.getRandomFutureDate();
        System.out.println("Random Future Date : " + futureDate);

        String pastDate = DatesManager.getRandomPastDate();
        System.out.println("Random Past Date : " +pastDate);
    }
}
