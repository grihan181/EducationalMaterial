package com.company;

public class Main {
    public static void main(String[] args) {
        String str = "А роза упала на лапу Азора";
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");
        StringBuilder strRevBuild = new StringBuilder(str).reverse();
        String strRev = strRevBuild.toString();

        System.out.println("\nПредложение ="+str);
        System.out.println("Обратное ему ="+strRev);

        if (str.equals(strRev)) {
            System.out.println ("\nЭто полиндроп");
        }
        else {
            System.out.println ("\nЭто не полиндроп");
        }
    }
}