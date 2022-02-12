package com.company;
public class TaskFive {
    public static void main(String[] args) {
        String str = "Hello world!";
        System.out.println("Выводим на экран посимвольно строку \"Hello World!\", рядом с символом написан его числовой код");
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                System.out.println(str.charAt(i) + "-" + (int) str.charAt(i));
            }
            else {
                System.out.println("space-" + (int) str.charAt(i));
            }
        }
    }
}