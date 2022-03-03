package com.company;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {

        System.out.println("Введите число N: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] array = new int[N][N];
        int minRow = 0, maxRow = N - 1, minCol = 0, maxCol = N - 1;
        int count = 1;

        boolean breakFlag = false;
        boolean secondCircle = false;

        System.out.println("Ваша спираль: ");

        while (!breakFlag) {
            if (secondCircle) {
                maxCol--;
            }

            for (int i = minCol; i <= maxCol; i++) {
                array[minRow][i] = count;
                count++;
            }
            minRow++;
            if (secondCircle) {
                maxRow--;
            }

            for (int i = minRow; i <= maxRow; i++) {
                array[i][maxCol] = count;
                count++;
            }
            maxCol--;
            if (secondCircle) {
                minCol++;
            }

            for (int i = maxCol; i >= minCol; i--) {
                array[maxRow][i] = count;
                count++;
            }
            maxRow--;
            minRow++;

            for (int i = maxRow; i >= minRow; i--) {
                array[i][minCol] = count;
                count++;
            }
            minCol++;

            secondCircle = true;
            if(maxCol < 0 || maxRow < 0) {
                breakFlag = true;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println("");
        }
    }
}
