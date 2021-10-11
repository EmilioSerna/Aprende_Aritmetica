package com.emilioserna.aprendearitmtica;

public class Random {

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int getRandomNumber() {
        return (int) ((Math.random() * (10 - 1)) + 1);
    }
}
