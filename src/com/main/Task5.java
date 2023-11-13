package com.main;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        double[] array = {10.5, -3.2, 4.7, -2.1, 15.5, 20.3, 17.9};
        var scanner = new Scanner(System.in);
        System.out.print("Введіть число А: ");
        double A = scanner.nextDouble();

        System.out.println("Кількість елементів менших за " + A + ": " + countElementsLessThan(array, A));
        System.out.println("Сума цілих частин після останнього від’ємного: " + sumAfterLastNegative(array));
        rearrangeArray(array);
        System.out.println("Перетворений масив: " + Arrays.toString(array));
    }

    private static int countElementsLessThan(double[] array, double A) {
        int count = 0;
        for (double value : array) {
            if (value < A) {
                count++;
            }
        }
        return count;
    }

    private static int sumAfterLastNegative(double[] array) {
        int sum = 0;
        boolean foundNegative = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < 0) {
                foundNegative = true;
                break;
            }
        }

        if (foundNegative) {
            int i = 0;
            for (i = i + 1; i < array.length; i++) {
                sum += (int) array[i];
            }
        }
        return sum;
    }

    private static void rearrangeArray(double[] array) {
        Arrays.stream(array).max().ifPresent(max -> {
            double threshold = max * 0.20;

            double[] closeToMax = Arrays.stream(array).filter(x -> Math.abs(max - x) <= threshold).toArray();
            double[] others = Arrays.stream(array).filter(x -> Math.abs(max - x) > threshold).toArray();

            Arrays.sort(closeToMax);
            Arrays.sort(others);

            System.arraycopy(closeToMax, 0, array, 0, closeToMax.length);
            System.arraycopy(others, 0, array, closeToMax.length, others.length);
        });
    }
}
