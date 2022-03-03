package com.company.TaskTwo;

import java.util.*;
import java.util.stream.Collectors;

public class TaskTwo {
    public static void main(String[] args) {
        System.out.println("Введите массив, разделитель пробел: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] splitText = text.split(" ");
        Sentence sentence = new Sentence(splitText);

        Operation sort = (sentence1) -> sentence1.getStringWords().stream()
                .distinct()
                .collect(Collectors.toList());

        String[] sentenseWintOutD = sort.deleteD(sentence).toArray(String[]::new);
        Sentence newSentense = new Sentence(sentenseWintOutD);
        System.out.println("Без дубликатов: " + newSentense.getOriginalSentence());
    }
}