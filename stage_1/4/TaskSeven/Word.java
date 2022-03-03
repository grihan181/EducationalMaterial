package com.company.TaskSeven;

public class Word {
    private char[] word;

    public char[] getWord() {
        return word;
    }
    public void setWord(char[] word) {
        this.word = word;
    }

    public Word(String word) {
        if(word == null || "".equals(word.trim())) {
            throw new IllegalArgumentException("Слово не может быть пустым");
        }
        this.word = word.toCharArray();
    }

    public int getSymbolCount() {
        return word.length;
    }
    public String getOriginalWord() {
        return new String(word);
    }
}
