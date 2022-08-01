package com.rootcodelabs.java.variables;

import com.github.javafaker.Faker;

public class StringHomework {

    public static void main(String[] args) {

        String price1 = "10.5";
        String price2 = "12.5";

        Double totalPrice = Double.parseDouble(price1) + Double.parseDouble(price2);
        System.out.println("Total is USD " + totalPrice);

        String address1 = "No.89";
        String address2 = "Galle Road";
        String address3 = "Hikkaduwa";

        String fullAddress = getAddress(address1,address2,address3);
        System.out.println(fullAddress);

        Faker faker = new Faker();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        System.out.println(String.format("Phone number is - " +phoneNumber));

        String address = faker.address().fullAddress();
        System.out.println(String.format("Address is - " +address));

    }

    /**
     * Get the Full Address
     * @param address1
     * @param address2
     * @param address3
     * @return Full address
     */
    private static String getAddress(String address1, String address2, String address3){
        String fullAddress = String.format("Address is - %s, %s, %s", address1,address2,address3 );
        return fullAddress;
    }


}
