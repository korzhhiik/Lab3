package com.main;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 3, 3, 3, 2};
        int maxLength = findMaxConsecutiveLength(array);
        System.out.println("Найбільша кількість підряд розміщених однакових елементів: " + maxLength);
    }

    private static int findMaxConsecutiveLength(int[] array) {
        if (array == null || array.length == 0) return 0;

        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentLen++;
                maxLen = Math.max(maxLen, currentLen);
            } else {
                currentLen = 1;
            }
        }

        return maxLen;
    }
}
