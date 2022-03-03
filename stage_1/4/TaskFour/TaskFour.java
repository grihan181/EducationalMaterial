package com.company.TaskFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String text = sc.nextLine();
        System.out.println("Введите количество копий N");
        int N = sc.nextInt();
        System.out.println("Ввкдите ограничение на общую длину L");
        int L = sc.nextInt();
        System.out.println("Введите максимально количество слов М");
        int M = sc.nextInt();

        Operation operation = (text1, N1, L1, M1) -> {
            text1 = text1.substring(0, L1);
            String[] textCopy = text1.split(" ");

            List<String> changing = Arrays.stream(textCopy).limit(M1).collect(Collectors.toList());
            String textChanging = String.join(",", changing);

            for (int i = 0; i < N1; i++) {
                System.out.println(i + 1 + ") " + textChanging);
            }
        };
        operation.copy(text, N, L, M);
    }
}
//Мама упала на лапу соседа