package com.company.TaskFour;

import java.util.*;

public class TaskFour {

    public static void main(String[] args) {
        HashSet<BuisinessRecord> buisinessRecords = new HashSet<BuisinessRecord>();


        int  choice;

        do {
            choice = menu1();
            if(buisinessRecords.size()==0 && choice == 0) {
                System.out.println("Введите хотябы 1 запись");
                choice = 1;
            } else if(choice == 1){
                buisinessRecords.add(createBuisnessRecord());
            }
        }while (choice != 0);
        Diary diary = new Diary(buisinessRecords);

        do {
            choice = menu2(diary);

        }while (choice != 0);


    }
    public static int menu1() {
        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("""
                1)Создать запись
                0)Перейти к действиям
                """);
        choice = sc.nextInt();
        if (-1 > choice || choice > 1) {
            System.out.println("Такого варианта нет");
            return -1;
        }
        return choice;
    }
    public static int menu2(Diary diary) {
        Scanner sc = new Scanner(System.in);
        String choiceString;
        int choice;
        DateTime dateTime = new DateTime();
        BuisinessRecord buisinessRecord;

        System.out.println("""
                \n1)Поиск записи по дате/времени создания
                2)Удаление записи по дате/времени создания
                3)Корректировка записи (искать по дате/времени создания)
                4)Показать все записи (задать сортировку по
                возрастанию/убыванию дату/времени создания)
                5)Показать запись (искать по дате/времени создания)
                6)Показать последнюю запись по дате/времени создания
                0)Выйти из программы\n
                """);
        choiceString = sc.nextLine();
        switch (choiceString) {
            case "1":
                System.out.println("Введите дату по которой нужноо произвести поиск в формате (dd-MM-yyyy/HH:mm:ss): ");
                choiceString = sc.nextLine();
                dateTime.setDateTime(choiceString);
                if ((buisinessRecord = diary.searchByDateTime(dateTime)) != null) {
                    System.out.println("\nЗапись найдена!\n");
                    buisinessRecord.printBuisnessRecord();
                } else {
                    System.out.println("\nК сожалению запись не была найдена\n");
                    getBack(diary);
                }

                break;
            case "2":
                System.out.println("Введите дату записи, которую хотите удалить в формате (dd-MM-yyyy/HH:mm:ss): ");
                choiceString = sc.nextLine();
                dateTime.setDateTime(choiceString);
                if (diary.delete(dateTime)) {
                    System.out.println("Запись удалена!");
                } else {
                    System.out.println("К сожалению запись не была найдена");
                    getBack(diary);
                }
                break;
            case "3":
                System.out.println("Введите дату записи, которую хотите отредактировать в формате (dd-MM-yyyy/HH:mm:ss): ");
                choiceString = sc.nextLine();
                dateTime.setDateTime(choiceString);
                diary.correct(dateTime);
                break;
            case "4":
                System.out.println("""
                        Как вы хотите вывести записи:
                        1)По возрастанию даты создания
                        2)по уменьшению даты создания """);
                choiceString = sc.nextLine();
                if (choiceString.equals("1")) {
                    diary.showAll(true);
                } else if (choiceString.equals("2")) {
                    diary.showAll(false);
                } else {
                    System.out.println("Такого варианта нет");
                    getBack(diary);
                }
                break;
            case "5":
                System.out.println("Введите дату записи которую нужно показать, в формате (dd-MM-yyyy/HH:mm:ss): ");
                choiceString = sc.nextLine();
                dateTime.setDateTime(choiceString);

                if ((buisinessRecord = diary.showByDateTime(dateTime)) != null) {
                    System.out.println("Запись найдена!");
                    buisinessRecord.printBuisnessRecord();
                } else {
                    System.out.println("К сожалению запись не была найдена");
                    getBack(diary);
                }
                break;
            case "6":
                diary.showLast().printBuisnessRecord();
                break;
            case "0":
                return 0;
            default:
                System.out.println("Такого варианта нет");
                return 1;
        }
                return 1;
    }
    public static BuisinessRecord createBuisnessRecord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите новую запись, через пробел в конце укажите дату и время запланированного дела в формате (dd-MM-yyyy/HH:mm:ss):\n(Пример записи: \"Надо почистить зубы 25-02-2022/20:00:00\")\n ");
        String buisnessRecord = sc.nextLine();
        return new BuisinessRecord(buisnessRecord);
        }

    public static void getBack(Diary diary) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("1)Вернуться назад");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                menu2(diary);
                break;
            default:
                System.out.println("Такого выбора нет, введите еще раз");
                getBack(diary);
        }
    }
}
