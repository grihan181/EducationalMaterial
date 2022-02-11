package com.company;
public class Main {
    public static void main(String[] args) {
        String str = "Hello world!";
        System.out.println("Выводим на экран посимвольно строку “Hello World!”, рядом с символом написан его числовой код");
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        for (char c : ch) {
            if (c != ' ') {
                System.out.println(c + "-" + (int) c);
            }
            else {
                System.out.println("space-" + (int) c);
            }
        }
    }
}