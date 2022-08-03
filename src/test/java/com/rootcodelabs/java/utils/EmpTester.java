package com.rootcodelabs.java.utils;

public class EmpTester {

    public static void main(String[] args) {

        EmployeeDetails employeeDetails = EmpDataManager.getEmployeeDetails();

        EmployeeDetails firstEmployee = EmpDataManager.getEmployeeDetails();
        System.out.println(firstEmployee.getFirstName());
        System.out.println(firstEmployee.getLastName());
        System.out.println(firstEmployee.getMiddleName());
        System.out.println(firstEmployee.getUserName());
        System.out.println(firstEmployee.getEmpNumber());
        System.out.println(firstEmployee.getBirthday());
    }
}
