package com.main;

import java.util.Random;

public class Task7 {
    public static void main(String[] args) {
        int[] array = new int[200];
        fillArray(array, -50, 50);
        int pairsCount = countPairsWithEqualValues(array);
        System.out.println("Кількість пар сусідніх елементів з однаковими значеннями: " + pairsCount);
    }

    private static void fillArray(int[] array, int min, int max) {
        var random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
    }

    private static int countPairsWithEqualValues(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
