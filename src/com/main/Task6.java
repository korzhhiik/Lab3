package com.main;

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        double[] array = {-1.5, 3.2, -4.7, 2.1, -0.5, 1.3};
        System.out.println("Кількість від’ємних елементів: " + countNegativeElements(array));
        System.out.println("Сума модулів після мінімального за модулем: " + sumOfModulusAfterMinByModulus(array));
        squareNegativeElements(array);
        Arrays.sort(array);
        System.out.println("Упорядкований масив: " + Arrays.toString(array));
    }

    private static int countNegativeElements(double[] array) {
        int count = 0;
        for (double value : array) {
            if (value < 0) {
                count++;
            }
        }
        return count;
    }

    private static double sumOfModulusAfterMinByModulus(double[] array) {
        int minModIndex = 0;
        double minMod = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i]) < minMod) {
                minMod = Math.abs(array[i]);
                minModIndex = i;
            }
        }

        double sum = 0;
        for (int i = minModIndex + 1; i < array.length; i++) {
            sum += Math.abs(array[i]);
        }
        return sum;
    }

    private static void squareNegativeElements(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = Math.pow(array[i], 2);
            }
        }
        Arrays.sort(array);
    }
}
