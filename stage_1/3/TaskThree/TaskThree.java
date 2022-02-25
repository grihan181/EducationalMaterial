package com.company.TaskThree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TaskThree {
    private static final int U = 220;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Electrodevice> electrodevices = new ArrayList<Electrodevice>();

        String maximumLoadString, chislo = "";
        int maximumLoad, choice;
        double currentLoad;


        System.out.println("Задайте максимально допустимую нагрузку: ");
        maximumLoadString = sc.nextLine();
        for (int i = 0; i < maximumLoadString.length(); i++) {
                while (i < maximumLoadString.length() && Character.isDigit(maximumLoadString.charAt(i))) {
                    chislo += maximumLoadString.charAt(i++);
                }
            }
        maximumLoad = Integer.parseInt(chislo);

        do {
            choice = menu1();
            if(electrodevices.size()==0 && choice == 0) {
                System.out.println("Введите хотябы 1 прибор");
                choice = 1;
            } else if(choice != 0){
                electrodevices.add(createElectroDevice(choice));
            }
        }while (choice != 0);

        makeStatusOfElectrodevices(electrodevices);

      do  {
            choice = menu2();
                switch (choice) {
                    case 1->printAllElectrodevices(electrodevices);
                    case 2-> printOnElectrodevices(electrodevices);
                    case 3-> printOffElectrodevices(electrodevices);
                }
            }while (choice != 0);

        if(maximumLoad >= getLoad(getFullWattage(electrodevices), U)) {
            System.out.println("Поздравляю, вы не превысили максимально допустимую силу тока");
        } else {
            sortList(electrodevices);
            for (int i = 0; i < electrodevices.size(); i++) {
                double a = getLoad(getFullWattage(electrodevices), U);
                currentLoad = getLoad(getFullWattage(electrodevices)-electrodevices.get(i).getWattage(), U) ;
                if (maximumLoad >= currentLoad) {
                    System.out.println("Вы превысили максимально допустимую силу тока предлагаю выключить " + electrodevices.get(i) +
                            "\nВы согласны?" +
                            "\n1)Да" +
                            "\n2)Нет");
                    choice = sc.nextInt();
                    while(choice != 2) {
                        if (choice == 1) {
                            electrodevices.get(i).switchOff();
                            choice = 2;
                            i = electrodevices.size();
                            System.out.println("Поздравляю, вы не превысили максимально допустимую силу тока ");
                            printOnElectrodevices(electrodevices);
                        } else {
                            System.out.println("Такого выбора нет!");
                        }
                    }
                }
                if(i == electrodevices.size()-1 && maximumLoad >= currentLoad) {
                    System.out.println("К сожалению я не смогла подобрать прибор, который необходимо выключить или вы отказались от всех моих вариантов");
                }
            }
        }
    }

    public static int menu1() {
        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("""
                Выберите нужный электроприбор(в скобках указано сренее значение в Ваттах):
                1)Холодильник(200Ватт)
                2)Миксер(300Ватт)
                3)Чайник(1500Ватт)
                4)TV(170Ватт)
                5)Пылесос(1800Ватт)
                6)Кондиционер(2000Ватт)
                0)Перейти к след. шагу
                """);
        choice = sc.nextInt();
        if (-1 > choice || choice > 6) {
            System.out.println("Такого прибора нет");
            menu1();
        }
        return choice;
    }
    public static int menu2() {
        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("""
                \nВыберите нужное действие:
                1)Вывести все приборы
                2)Вывести только вклченные приборы
                3)Вывести только выключенные приборы
                0)Перейти к след. шагу
                """);
        choice = sc.nextInt();
        if (-1 > choice || choice > 3) {
            System.out.println("Такого варианта нет");
        }
        return choice;
    }

    public static Electrodevice createElectroDevice(int choice) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите мощность прибора в Ваттах: ");
        int wattage = sc.nextInt();
        return switch (choice) {
            case 1 -> new Fridge(wattage);
            case 2 -> new Mixer(wattage);
            case 3 -> new Teakettle(wattage);
            case 4 -> new TV(wattage);
            case 5 -> new VacuumCleaner(wattage);
            case 6 -> new Conditioner(wattage);
            default -> null;
        };
    }
    public static void makeStatusOfElectrodevices(ArrayList<Electrodevice> electrodevices) {
        int choice = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой прибор вы хотите включить/выключить напишите номер(если хотите закончить пишите 0): ");
        choice = sc.nextInt() - 1;
        if (choice < -1 || choice >= electrodevices.size()) {
            System.out.println("Такого прибора нет");
            makeStatusOfElectrodevices(electrodevices);
        } else if (choice == -1) {
            return;
        } else {
            if (electrodevices.get(choice).getStatus() == 0) {
                electrodevices.get(choice).switchOn();
            } else {
                electrodevices.get(choice).switchOff();
            }
            makeStatusOfElectrodevices(electrodevices);
        }
    }
    public static void printAllElectrodevices(ArrayList<Electrodevice> electrodevices) {
        System.out.println("\nВсе созданные вами приборы:\n");
        for (int i = 0; i < electrodevices.size(); i++) {
            System.out.println(i+1 + ") Имя: " + electrodevices.get(i) + "\nМощность прибора: " + electrodevices.get(i).getWattage() + "\nСтатус: " +  electrodevices.get(i).getStatusString());
        }
    }
    public static void printOnElectrodevices(ArrayList<Electrodevice> electrodevices) {
        System.out.println("\nВключенные приборы:\n");
        for (int i = 0; i < electrodevices.size(); i++) {
            if (electrodevices.get(i).getStatus() == 1) {
                System.out.println(i+1 + ") Имя: " + electrodevices.get(i) + "\nМощность прибора: " + electrodevices.get(i).getWattage() + "\nСтатус: " +  electrodevices.get(i).getStatusString());
            }
        }
    }
    public static void printOffElectrodevices(ArrayList<Electrodevice> electrodevices) {
        System.out.println("\nВыключенные приборы:\n");
        for (int i = 0; i < electrodevices.size(); i++) {
            if (electrodevices.get(i).getStatus() == 0) {
                System.out.println(i+1 + ") Имя: " + electrodevices.get(i) + "\nМощность прибора: " + electrodevices.get(i).getWattage() + "\nСтатус: " +  electrodevices.get(i).getStatusString());
            }
        }
    }
    public static int getFullWattage(ArrayList<Electrodevice> electrodevices) {
        int fullWattage = 0;
        for (Electrodevice electrodevice : electrodevices) {
            if (electrodevice.getStatus() == 1) {
                fullWattage += electrodevice.getWattage();
            }
        }
        return fullWattage;
    }
    public static double getLoad(int P, int U) {
        return (double) P / U;
    }

    public static ArrayList<Electrodevice> sortList(ArrayList<Electrodevice> electrodevices) {
        Collections.sort(electrodevices);

        for(int i = 0; i < electrodevices.size(); i++) {
                if (electrodevices.get(i).getStatus() == 0) {
                    electrodevices.remove(i);
                    i=0;
                }
            }


            return electrodevices;
    }
}