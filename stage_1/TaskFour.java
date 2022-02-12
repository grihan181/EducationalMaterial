package com.company;
public class TaskFour {
    public static void main(String[] args) {
        int[] mass =new int[30];
        System.out.println("Созданный рандомный массив:");
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) Math.round((Math.random() * 20) - 10);
            System.out.print(mass[i]+" ");
            if ((i+1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}