package com.company;

public class Main {
    public static void main(String[] args) {
        String str = " Hello world! ";
        int count = 0 ;
        System.out.println("В строке " Hello world! "\nИмеются совпадающие символы:\n");
        for (int i = 0; i < str.length()+1; i++) {
            i=0;
            for (int j = 0; j < str.length(); j++) {

                if(str.charAt(i)==str.charAt(j))
                {
                    count++;
                }

            }
            if(count != 1) {
                if (str.charAt(i) != ' ') {
                    System.out.println(str.charAt(i) + "--" + count);
                } else {
                    System.out.println("space--" + count);
                }
            }
                String d = String.valueOf(str.charAt(i));
                str = str.replaceAll(d, "");
                count = 0;
        }
    }
}