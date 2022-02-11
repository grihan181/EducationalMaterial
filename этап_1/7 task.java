package com.company;

public class Main {
    public static void main(String[] args) {
        int number = 100;
        do {
            System.out.println(number + " бутылок стояло на столе, одна из них упала и разбилась.");
            number--;
            if(number == 0) {
                System.out.println( "Все бутылки разбились.");
            }
        }while(number != 0);
    }