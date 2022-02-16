package com.company.TaskFive;
import java.util.Scanner;

public class TaskFive {
    public static void main(String[] args) {

        System.out.println("Введите текст: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] splitText = text.split(" ");
        Sentence sentence = new Sentence(splitText);

        System.out.println("Модель создана");
    }
}
