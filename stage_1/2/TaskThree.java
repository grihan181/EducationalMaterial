package com.company;
import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Введите номер к-позиции символа в словах и новый символ для замены: ");
        int kNumber = sc.nextInt();
        kNumber --;

        char newSymbol = sc.next().charAt(0);

        String[] wordsArray = text.split(" ");

        for(String word : wordsArray){
            char[] character = word.toCharArray();
            for(int i = 0 ;i < character.length; i++){
                if(i == kNumber){
                    character[i] = newSymbol;
                }
            }
           word = new String(character);
           System.out.print(word + " ");
        }
    }
}