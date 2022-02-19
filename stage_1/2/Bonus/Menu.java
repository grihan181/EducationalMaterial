package com.company.Bonus;
import java.util.Scanner;
public class Menu {
    private int answer;
    private int answer2;
    private boolean checking = false;
    private MyList action = new MyList();
    private Scanner sc = new Scanner(System.in);
    public void start() {
        System.out.println("Что хотите сделать со списком? Выберите дейстиве и напишите цифру\n" +
                "1) Добавить элемент;\n" +
                "2) Вставить элемент в конкретное место;\n" +
                "3) Удалить элемент;\n" +
                "4) Отсортировать список;\n" +
                "5) Очистить список;\n" +
                "6) Вывести список;\n" +
                "7) Завершить работу.");
        answer = sc.nextInt();
        System.out.println(answer);
        switch (answer) {
            case(1):
                System.out.println("Введите элемент");
                answer = sc.nextInt();
                action.setNumIntTheEnd(answer);
                checking = true;
                break;
            case(2):
                if(checking==false) {
                    System.out.println("\nВы не создали список, введите в него элементы\n");
                    break;
                }
                System.out.println("Введите номер в списке в который необходимо вставить и сам элемент");
                answer = sc.nextInt();
                answer2 = sc.nextInt();
                action.insertNum(answer, answer2);
                break;
            case(3):
                if(checking==false) {
                    System.out.println("\nВы не создали список, введите в него элементы\n");
                    break;
                }
                System.out.println("Введите номер элемента");
                answer = sc.nextInt();
                action.removeNum(answer);
                break;
            case(4):
                if(checking==false) {
                    System.out.println("\nВы не создали список, введите в него элементы\n");
                    break;
                }
                action.sortMyList();
                System.out.println("Список отсортирован");
                break;
            case(5):
                if(checking==false) {
                    System.out.println("\nВы не создали список, введите в него элементы\n");
                    break;
                }
                action.deleteList();
                System.out.println("Список очищен");
                MyList action2 = new MyList();
                this.action = action2;
                break;
            case(6):
                if(checking==false) {
                    System.out.println("\nВы не создали список, введите в него элементы\n");
                    break;
                }
                System.out.println("\nВаш список: " + action.printList());
                break;
            case(7):
                return;
            default:
                System.out.println("Такого варианта нет, введите еще раз");
                break;
        }
        start();

    }
}
