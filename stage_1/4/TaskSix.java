package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сколько простых чисел N нужно вывести: ");
        int N = sc.nextInt();
        int count = 0;
        int i = 2;
        ArrayList<Integer> lst = new ArrayList<>();

        while(count != N) {
            boolean bool = true;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if ((i % j) == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool)  {
                count++;
                lst.add(i);
            }
            i++;
        }
        System.out.println("Простые числа: ");
        System.out.println(lst);
    }
}
