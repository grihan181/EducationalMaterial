package com.company;

public class Main {

    public static void main(String[] args) {
        int[] mass =new int[30];
        int count = 0;
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) Math.round((Math.random() * 20) - 10);
            System.out.print(mass[i]+" ");
            count++;
            if (count == 10) {
                System.out.println();
                count = 0;
            }
        }
    }
}
