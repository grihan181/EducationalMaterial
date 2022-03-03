package com.company.TaskThree;

import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = sc.nextInt();
        Operation operation = (num1) -> {
            return num1 % 13 != 0;
        };
        if(operation.checking(num)) {
            System.out.println("Делится с остатком");
        } else {
            System.out.println("Делится без остатка");
        }

    }
}
