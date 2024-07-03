package com.example.demox;

public class Utils {

    public static String getWelcome(String name, boolean isCustomer) {

        if (isCustomer) {
            return "Dear " + name;
        } else {
            return "Hello " + name;
        }
    }
}
