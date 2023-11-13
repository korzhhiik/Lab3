package com.main;

import java.util.Random;

public class Task8 {
    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = fillMatrixWithRandomNumbers(size, -10, 10);
        int Z = 3;

        System.out.println("Оригінальна матриця:");
        printMatrix(matrix);

        System.out.println("Сума значень додатних елементів матриці: " + sumOfPositiveElements(matrix));

        System.out.println("Кількість елементів в кожному стовпці, що не перевищують " + Z + ":");
        printElementsCountLessOrEqualZ(matrix, Z);

        int[][] transposedMatrix = transposeMatrix(matrix);
        System.out.println("Транспонована матриця:");
        printMatrix(transposedMatrix);

        int[][] sumMatrix = addMatrices(matrix, transposedMatrix);
        System.out.println("Сума оригінальної та транспонованої матриць:");
        printMatrix(sumMatrix);
    }

    private static int[][] fillMatrixWithRandomNumbers(int size, int min, int max) {
        int[][] matrix = new int[size][size];
        var random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matrix;
    }

    private static int sumOfPositiveElements(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value > 0) {
                    sum += value;
                }
            }
        }
        return sum;
    }

    private static void printElementsCountLessOrEqualZ(int[][] matrix, int Z) {
        for (int j = 0; j < matrix[0].length; j++) {
            int count = 0;
            for (int[] row : matrix) {
                if (row[j] <= Z) {
                    count++;
                }
            }
            System.out.println("Стовпець " + (j + 1) + ": " + count);
        }
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        int[][] transposed = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    private static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] sumMatrix = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
