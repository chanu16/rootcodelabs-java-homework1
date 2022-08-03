package com.rootcodelabs.java.utils;

public class EmployeeDetails {

    private String firstName;
    private String lastName;
    private String middleName;
    private String userName;
    private String empNumber;
    private String birthday;

    public EmployeeDetails() {
        this.firstName = EmpDataManager.getFirstName();
        this.lastName = EmpDataManager.getLastName();
        this.middleName = EmpDataManager.getMiddleName();
        this.userName = String.format("%s.%s", firstName, lastName).toLowerCase();
        this.empNumber = EmpDataManager.getEmpNumber();
        this.birthday = EmpDataManager.getBirthday();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmpNumber(){
        return empNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return String.valueOf(System.out.format("%s, %s", this.firstName, this.lastName));
    }
}
