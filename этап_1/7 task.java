package com.company;

public class Main {
    public static void main(String[] args) {
        int number = 100;
        do {
            switch(number%10) {
                case 4,3,2:
                    if(number % 100 == 12|| number % 100 == 13|| number % 100 == 14) {
                        System.out.println(number + " бутылок стояло на столе, одна из них упала и разбилась.");
                    }
                    else {
                        System.out.println(number + " бутылки стояло на столе, одна из них упала и разбилась.");
                    }
                    break;
                case 1:
                    if(number % 100 == 11) {
                        System.out.println(number + " бутылок стояло на столе, одна из них упала и разбилась.");
                    }
                    else {
                        System.out.println(number + " бутылка стояла на столе, одна из них упала и разбилась.");
                    }
                    break;
                default:
                    System.out.println(number + " бутылок стояло на столе, одна из них упала и разбилась.");
                    break;
            }
            number--;
            if(number == 0) {
                System.out.println( "Все бутылки разбились.");
            }
        }while(number != 0);
    }
}