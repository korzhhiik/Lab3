package com.main;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        double[] array = {1.5, -3.2, 4.7, -2.1, 0.5, 3.9};
        double negativeSum = sumNegativeElements(array);
        double productBetweenMaxMin = productBetweenMaxAndMin(array);
        Arrays.sort(array);

        System.out.println("Сума від'ємних елементів: " + negativeSum);
        System.out.println("Добуток елементів між максимальним і мінімальним: " + productBetweenMaxMin);
        System.out.println("Відсортований масив: " + Arrays.toString(array));
    }

    private static double sumNegativeElements(double[] array) {
        double sum = 0;
        for (double value : array) {
            if (value < 0) {
                sum += value;
            }
        }
        return sum;
    }

    private static double productBetweenMaxAndMin(double[] array) {
        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        int start = Math.min(maxIndex, minIndex) + 1;
        int end = Math.max(maxIndex, minIndex);

        double product = 1;
        for (int i = start; i < end; i++) {
            product *= array[i];
        }
        return product;
    }
}
