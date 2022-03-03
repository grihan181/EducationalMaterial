package com.company.TaskSeven;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class TaskSeven {
    private static final List<Character> VOWELS = Arrays.asList('а','о', 'э', 'е', 'и', 'ы', 'у', 'ё', 'ю', 'я');

    public static void main(String[] args) throws IOException {
        String fileLocatioon = "text.txt";
        String semtemceWords = "";



        FileReader fileReader = new FileReader(fileLocatioon);
        Scanner scan = new Scanner(fileReader);

        while (scan.hasNext()) {
            semtemceWords += scan.next() + " ";
        }
        Sentence sentence = new Sentence(semtemceWords);
        fileReader.close();

        Operation sort = (sentence1) -> sentence1.getStringWords().stream()
                .distinct()
                .collect(Collectors.toList());

        String[] sentenseWintOutD = sort.deleteD(sentence).toArray(String[]::new);
        Sentence newSentense = new Sentence(sentenseWintOutD);
        System.out.println("Без дубликатов: " + newSentense.getOriginalSentence());

        analizator(sentence);
        System.out.println("\nВсе выполнилось успешно!");

    }
    public static void analizator(Sentence sentence) {
        int countWord = 0;
        int countVowelsWord = 0;
        int countConsonantsWord = 0;


        UnaryOperator<Integer> countingWord = (countWords) -> sentence.getWordsCount();

        UnaryOperator<Integer> countingVowelsWord = (countVowelsWords) -> {

           for(int i = 1; i <=  sentence.getWordsCount(); i++) {
                if (VOWELS.contains(sentence.getWordByPosition(i).getOriginalWord().toLowerCase().charAt(0))) {
                    countVowelsWords++;
                }
            }
            return countVowelsWords;
        };

        UnaryOperator<Integer> countingConsonantsWord = (countConsonantsWords) -> {

            for(int i = 1; i <= sentence.getWordsCount(); i++) {
                if (!VOWELS.contains(sentence.getWordByPosition(i).getOriginalWord().toLowerCase().charAt(0))) {
                    countConsonantsWords++;
                }
            }
            return countConsonantsWords;
        };


        try {
            FileWriter writer = new FileWriter("result.txt");
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.printf("Анализ текста.\nВсего слов - %d\nИз них:\nC гласной - %d\nC согласной - %d",
                    countingWord.apply(countWord), countingVowelsWord.apply(countVowelsWord), countingConsonantsWord.apply(countConsonantsWord));

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
