package com.company;

public class TaskNine {
    public static void main(String[] args) {
        String str = "А роза упала на лапу Азора";
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");
        int j = str.length()-1;
        boolean polindr = true;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(j)) { polindr = false; }
            j--;
        }
        if (polindr) {
            System.out.println ("\nЭто полиндроп");
        }
        else {
            System.out.println ("\nЭто не полиндроп");
        }
    }
}