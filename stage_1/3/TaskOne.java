package com.company;

import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число рядов и колонок: ");
        int rows = sc.nextInt();
        int columns = rows;
        System.out.println("Изначальная матрица: ");
        int[][] mainArray = new int[rows][columns];

        for (int[] row : mainArray) {
            for (int element : row)
                System.out.print(element);
            System.out.print("\n");
        }
        System.out.println("\nМатрица с крестом: ");
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                if (i == j || i + j == rows - 1) {
                    mainArray[i][j]++;
                    System.out.print(mainArray[i][j]);
                } else {
                    System.out.print(mainArray[i][j]);
                }
            }
            System.out.print("\n");
        }
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                mainArray[i][j] = 0;
            }
        }
        System.out.println("\nМатрица с плюсом: ");
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                if (j == mainArray[i].length / 2 || i == mainArray.length / 2) {
                    mainArray[i][j]++;
                    System.out.print(mainArray[i][j]);
                } else {
                    System.out.print(mainArray[i][j]);
                }
            }
            System.out.print("\n");
        }
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                mainArray[i][j] = 0;
            }
        }
        System.out.println("\nМатрица с квадратом: ");
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                if (i == 0 || j == 0 || i == mainArray.length - 1 || j == mainArray[i].length - 1) {
                    mainArray[i][j]++;
                    System.out.print(mainArray[i][j]);
                } else {
                    System.out.print(mainArray[i][j]);
                }
            }
            System.out.print("\n");
        }
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray[i].length; j++) {
                mainArray[i][j] = 0;
            }
        }
        System.out.println("\nМатрица с ромбом: ");
        int center = mainArray.length / 2;
        for (int i = 0; i < mainArray.length; i++) {
            for (int j = 0; j < mainArray.length; j++) {
                if (i <= center) {
                    if (j == center - i || j == center + i) {
                        mainArray[i][j]++;
                        System.out.print(mainArray[i][j]);
                    }
                    else
                        System.out.print(mainArray[i][j]);
                } else {
                    if (j == center + i - mainArray.length + 1 || j == center - i + mainArray.length - 1) {
                        mainArray[i][j]++;
                        System.out.print(mainArray[i][j]);
                    }
                    else
                        System.out.print(mainArray[i][j]);
                }
            }
            System.out.print("\n");
        }
    }
}
