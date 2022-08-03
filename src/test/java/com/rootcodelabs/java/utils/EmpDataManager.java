package com.rootcodelabs.java.utils;

import com.github.javafaker.Faker;

import java.util.Date;

public class EmpDataManager {

    public static void main(String[] args) {

    }

    public static String getFirstName(){
        Faker faker = new Faker();
        String firstName = faker.name().firstName().replaceAll("'", "").trim();
        return firstName;
    }

    public static String getLastName(){
        Faker faker = new Faker();
        String lastName = faker.name().firstName().replaceAll("'", "").trim();
        return lastName;
    }

    public static String getMiddleName(){
        return getLastName();
    }

    public static String getEmpNumber(){
        Faker faker = new Faker();
        String empNumber = ("EMP-RC: " + faker.number().numberBetween(1000, 2000));
        return empNumber;
    }

    public static String getBirthday(){
        Faker faker = new Faker();
        Date birthday = faker.date().birthday(18, 20);
        return birthday.toString();
    }

    public static EmployeeDetails getEmployeeDetails() {
        return new EmployeeDetails();
    }
}
