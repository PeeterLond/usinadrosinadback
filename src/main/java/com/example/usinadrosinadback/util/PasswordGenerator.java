package com.example.usinadrosinadback.util;

import java.security.SecureRandom;

public class PasswordGenerator {

    public static String newRandomPassword() {
        SecureRandom secureRandom = new SecureRandom();
        int length = 12 + secureRandom.nextInt(4);
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&*-_+?";
        String[] categories = {upper, lower, numbers, symbols};
        StringBuilder randomPassword = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String category = categories[secureRandom.nextInt(categories.length)];
            String ch = category.split("")[secureRandom.nextInt(category.length())];
            randomPassword.append(ch);
        }

        return randomPassword.toString();
    }

}
