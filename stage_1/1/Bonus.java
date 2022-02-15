package com.company;

public class Bonus {
    public static void main(String[] args){
        boolean a = true;
        boolean b = false;
        boolean c = false;
        boolean d = true;
        System.out.println(process(a,b,c,d));
    }
    public static boolean process(boolean a, boolean b, boolean c, boolean d) {
        return ( ( ( a ^ b ) && ( c ^ d ) ) || ( ( a ^ c ) && ( b ^ d ) ));
    }
}