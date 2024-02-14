package com.tran.trapp.utils;

import java.util.Random;
import java.util.UUID;

public class RandomTextGen {
    public static String generateEngString() {
        String uuid = UUID.randomUUID().toString();
        return "Test " + uuid;
    }
    public static String generateRuString() {
        StringBuilder randomText = new StringBuilder();
        String characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            int index = rand.nextInt(characters.length());
            randomText.append(characters.charAt(index));
        }
        return randomText.toString();
    }
}
