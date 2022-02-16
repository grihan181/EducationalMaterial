package com.company;
import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if(!Character.isLetter(textArray[i]) && !(textArray[i] == ' ')) {
                   String d = String.valueOf(textArray[i]);
                   text = text.replace(d, "");
            }
        }
        System.out.println(text);
    }
}

