package com.company.TaskFour;

import java.util.ArrayList;


public class Sentence {
    private ArrayList<Word> words = new ArrayList<Word>();


    public ArrayList<Word> getWords() {
        return words;
    }
    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public  void setWordsFromString(String words) {
        String[] wordsArray = words.split(" ");
        for(int i = 0; i < wordsArray.length; i++) {
            this.words.add(new Word(wordsArray[i]));
        }
    }

    public Sentence() {

    }
    public Sentence(String[] words) {
        for(int i = 0; i < words.length; i++) {
            this.words.add(new Word(words[i]));
        }
    }
    public Sentence(String words) {
        String[] wordsArray = words.split(" ");
        for(int i = 0; i < wordsArray.length; i++) {
            this.words.add(new Word(wordsArray[i]));
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
        for (int i = 0; i< words.size(); i++) {
            originalSentence += words.get(i).getOriginalWord() + " ";
        }
        return originalSentence;
    }
    public void deleteDataTime(){
        words.remove(words.size()-1);
    }
}
