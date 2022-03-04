package com.company.TaskTwo;

import java.util.ArrayList;

public class Sentence {
    private ArrayList<Word> words = new ArrayList<Word>();


    public ArrayList<Word> getWords() {
        return words;
    }
    public ArrayList<String> getStringWords() {
        ArrayList<String> words = new ArrayList<String>();
        for (int i = 1; i <= getWordsCount(); i++) {
            words.add(getWordByPosition(i).getOriginalWord());
        }
        return words;
    }



    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public  void setWordsFromString(String words) {
        String[] wordsArray = words.split(" ");
        for (String s : wordsArray) {
            this.words.add(new Word(s));
        }
    }

    public Sentence(ArrayList<Word> words) {
        this.words = words;
    }
    public Sentence(String[] words) {
        for (String word : words) {
            this.words.add(new Word(word));
        }
    }
    public Sentence(String words) {
        String[] wordsArray = words.split(" ");
        for (String s : wordsArray) {
            this.words.add(new Word(s));
        }

    }

    public int getWordsCount() {
        return words.size();
    }
    public Word getWordByPosition(int pos) {
        return words.get(pos-1);
    }
    public String getOriginalSentence() {
        String originalSentence = "";
        for (Word word : words) {
            originalSentence += word.getOriginalWord() + " ";
        }
        return originalSentence;
    }
}
