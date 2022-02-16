package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class TaskFour {
    public static void main(String[] args) {
        System.out.println("Введите текст: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] wordsArray = text.split(" ");

        ArrayList<String> maxWords =  new ArrayList<String>();
        ArrayList<String> minWords = new ArrayList<String>();

        int maxLength = wordsArray[0].length();
        int minLength = wordsArray[0].length();

            for (String word : wordsArray) {
                if(maxLength < word.length()) { maxLength = word.length(); }
                if(minLength > word.length()) { minLength = word.length(); }
        }

            int i = 0;
            int j = 0;
        for (String word : wordsArray) {
            if (maxLength == word.length()) {
                maxWords.add(word);
                i++;
            }
            if (minLength == word.length()) {
                minWords.add(word);
                j++;
            }
        }
            System.out.println("Слова с максимальной длиной: " + String.join(" ", maxWords));
            System.out.println("Слова с минимальной длиной: " + String.join(" ", minWords));

    }
}
