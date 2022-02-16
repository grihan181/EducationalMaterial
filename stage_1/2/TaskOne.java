package com.company;
import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        System.out.println("Введите количество чисел в ряде Фибоначчи: ");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] febonacchi = new int[length];

        System.out.println("Ряд Фибоначчи: ");
        for (int i = 0; i < length; i++) {
            if (i < 2) {
                febonacchi[i] = i;
                System.out.print(febonacchi[i] + " ");
            } else {
                febonacchi[i] = febonacchi[i - 1] + febonacchi[i - 2];
                System.out.print(febonacchi[i] + " ");
            }
        }
    }
}