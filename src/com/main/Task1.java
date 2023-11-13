package com.main;

public class Task1 {
    public static void main(String[] args) {
        int[] array = { -3, 5, -2, 7, -8, 6 };
        replaceNegativeElements(array);
        printArray(array);
    }

    private static void replaceNegativeElements(int[] array) {
        int maxIndex = findFirstMaxIndex(array);

        for (int i = 0; i < maxIndex; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }
    }

    private static int findFirstMaxIndex(int[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
                break;
            }
        }
        return maxIndex;
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
