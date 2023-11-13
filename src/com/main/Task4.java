package com.main;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = {3, -4, 0, 5, -2, 7, 1};
        System.out.println("Мінімальний за модулем елемент: " + findMinByModulus(array));
        System.out.println("Сума модулів після першого нуля: " + sumOfModulusAfterZero(array));
        rearrangeArray(array);
        System.out.println("Перетворений масив: " + Arrays.toString(array));
    }

    private static int findMinByModulus(int[] array) {
        int minMod = Integer.MAX_VALUE;
        for (int value : array) {
            minMod = Math.min(minMod, Math.abs(value));
        }
        return minMod;
    }

    private static int sumOfModulusAfterZero(int[] array) {
        int sum = 0;
        boolean zeroFound = false;
        for (int value : array) {
            if (zeroFound) {
                sum += Math.abs(value);
            }
            if (value == 0) {
                zeroFound = true;
            }
        }
        return sum;
    }

    private static void rearrangeArray(int[] array) {
        int[] temp = new int[array.length];
        int halfSize = (array.length + 1) / 2;

        for (int i = 0, even = 0, odd = halfSize; i < array.length; i++) {
            if (i % 2 == 0) {
                temp[even++] = array[i];
            } else {
                temp[odd++] = array[i];
            }
        }
        System.arraycopy(temp, 0, array, 0, array.length);
    }
}
