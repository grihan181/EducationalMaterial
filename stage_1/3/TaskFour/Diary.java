package com.company.TaskFour;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Diary {
    private HashSet<BuisinessRecord> buisinessRecords = new HashSet<BuisinessRecord>();


    public void setBuisinessRecords(HashSet<BuisinessRecord> buisinessRecords) {
        this.buisinessRecords = buisinessRecords;
    }
    public HashSet<BuisinessRecord> getBuisinessRecords() {
        return buisinessRecords;
    }


    public Diary(HashSet<BuisinessRecord> buisinessRecords) {
        this.buisinessRecords = buisinessRecords;
    }
    public Diary(BuisinessRecord buisinessRecord) {
        this.buisinessRecords.add(buisinessRecord);
    }

    public BuisinessRecord searchByDateTime(DateTime dateTime) {
        BuisinessRecord buisinessRecord2 = new BuisinessRecord();
        buisinessRecord2.setCreatedWhen(dateTime);

        for (BuisinessRecord buisinessRecord : this.buisinessRecords) {
            if (buisinessRecord.hashCode() == buisinessRecord2.hashCode()) {
                return buisinessRecord;
            }
        }

        return null;
    }
    public boolean delete(DateTime dateTime) {
        BuisinessRecord buisinessRecord2 = new BuisinessRecord();
        buisinessRecord2.setCreatedWhen(dateTime);

        for (BuisinessRecord buisinessRecord : this.buisinessRecords) {
            if (buisinessRecord.hashCode() == buisinessRecord2.hashCode()) {
                buisinessRecords.remove(buisinessRecord);
                return true;
            }
        }
        return false;
    }
    public void correct(DateTime dateTime) {
        BuisinessRecord buisinessRecord2 = new BuisinessRecord();
        buisinessRecord2.setCreatedWhen(dateTime);

        Scanner sc = new Scanner(System.in);
        String choice;
        DateTime dateTime1 = new DateTime();

        for (BuisinessRecord buisinessRecord : this.buisinessRecords) {
            if (buisinessRecord.hashCode() == buisinessRecord2.hashCode()) {
                System.out.println("Вот ваша запись:");
                buisinessRecord.printBuisnessRecord();

                System.out.println("Введите новый текст: ");
                choice = sc.nextLine();
                buisinessRecord.setWordsFromString(choice);

                System.out.println("Вот ваша измененная запись:");
                buisinessRecord.printBuisnessRecord();
                return;
            }
        }
        System.out.println("К сожалению запись не была найдена, введите еще раз");
        choice = sc.nextLine();
        dateTime1.setDateTime(choice);
        correct(dateTime1);
    }

    public void showAll(boolean asc) {
        List<BuisinessRecord> list = new ArrayList<BuisinessRecord>();
        if (asc) {
           list.addAll(sort(1));
        }
        else {
            list.addAll(sort(2));
        }
        for(BuisinessRecord buisinessRecord : list) {
            buisinessRecord.printBuisnessRecord();
        }
    }

   public BuisinessRecord showByDateTime(DateTime dateTime) {
        return searchByDateTime(dateTime);
   }
    public BuisinessRecord showLast() {
        List<BuisinessRecord> list = new ArrayList<BuisinessRecord>(buisinessRecords);
        Collections.sort(list);
        return list.get(list.size()-1);
    }

    public  List<BuisinessRecord> sort(int choice) {
        List<BuisinessRecord> list = new ArrayList<BuisinessRecord>(buisinessRecords);

        Collections.sort(list);
        switch (choice) {
            case 1 ->  System.out.println("Список отсортирован по Возрастанию");
            case 2 -> {
                Collections.reverse(list);
                System.out.println("Список отсортирован по убыванию");
            }
            default -> {
                System.out.println("Такого варианта нет, введите еще раз");

            }
        }
        return list;
    }
    public LocalDateTime dateTimeToLocalDT(DateTime dateTime) {
        String choiceString = dateTime.getDateTimeString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy/HH:mm:ss");
        return LocalDateTime.parse(choiceString, formatter);
    }
}
