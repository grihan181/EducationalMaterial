package com.company;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskEight {
    public static void main(String[] args) {
        Making object = new Making();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите математическое выражение: ");
        String s = sc.nextLine();

        System.out.println(object.make(s));
    }
}
class Making {
    public boolean whatIsOperation(char c) {
        return c == '+' || c == '-' || c == '/'  || c == '*';
    }

    public int priorityOfOperator(char operator) {
        switch (operator) {
            case '+', '-':
                return 1;
            case '*', '/':
                return 2;
            default:
                return 0;
        }
    }

    public void counting(LinkedList<Integer> chislo, char znak) {
        int lastNunber = chislo.removeLast();
        int preLastNunber = chislo.removeLast();
        switch (znak) {
            case '+':
                chislo.add(preLastNunber + lastNunber);
                break;
            case '-':
                chislo.add(preLastNunber - lastNunber);
                break;
            case '*':
                chislo.add(preLastNunber * lastNunber);
                break;
            case '/':
                chislo.add(preLastNunber / lastNunber);
                break;
        }
    }

    public int make(String s) {

        Making obj = new Making();
        LinkedList<Integer> chisla = new LinkedList<Integer>();
        LinkedList<Character> operators = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (obj.whatIsOperation(c)) {
                while (!operators.isEmpty() && obj.priorityOfOperator(operators.getLast()) >= obj.priorityOfOperator(c))
                    counting(chisla, operators.removeLast());
                operators.add(c);
            }
            else {
                String chislo = "";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    chislo += s.charAt(i++);
                }
                --i;
                chisla.add(Integer.parseInt(chislo));
            }
        }
        while (!operators.isEmpty()) {
            counting(chisla, operators.removeLast());
        }
        return chisla.get(0);
    }
}