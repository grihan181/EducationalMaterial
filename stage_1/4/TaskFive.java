package com.company;

import java.util.Scanner;
import java.util.function.Predicate;

public class TaskFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число");
        int num = sc.nextInt();


        Predicate<Integer> isFeb = num1 -> {
            double tmp = 5 * num1 * num1 - 4;
            double tmp1 = 5 * num1 * num1 + 4;
            double sq = Math.sqrt(tmp);
            double sq1 =  Math.sqrt(tmp1);
            return sq * sq == tmp || sq1 * sq1 == tmp1;
        };
        if(isFeb.test(num)) {
            System.out.println("Число является элементом Фибоначчи");
        } else {
            System.out.println("Число не является элементом Фибоначчи");
        }
    }
}
