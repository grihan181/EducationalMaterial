package com.company;
public class TaskTwo {
    public static void main(String[] args) {
        int a = 13;
        int b = 30;
        float c = 7.7f;
        float d = 10.5f;
        float result = (float)  a * b / a - b ;
        float result1 = c + d;
        System.out.println("Наши исходные данные:");
        System.out.printf("a = %d\nb = %d\nc = %f\nd = %f\n", a, b, c, d);
        System.out.println("a * b / a - b = " + result);
        System.out.println("c + d = " + result1);
    }
}