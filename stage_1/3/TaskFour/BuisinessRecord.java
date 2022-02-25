package com.company.TaskFour;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class BuisinessRecord extends Sentence implements Comparable<BuisinessRecord> {

   private DateTime executeDate = new DateTime();
   private DateTime createdWhen = new DateTime();


   public BuisinessRecord() {
      super();
   }
   public BuisinessRecord(String[] words) {
      super(words);
      executeDate.setDateTime(words[words.length-1]);
      deleteDataTime();
      createdWhen.setDateTimeNow();
   }
   public BuisinessRecord(String words) {
      super(words);
      String[] wordsArray = words.split(" ");

      executeDate.setDateTime(wordsArray[wordsArray.length-1]);
      deleteDataTime();
      createdWhen.setDateTimeNow();
   }


   public DateTime getExecuteDate() {
      return executeDate;
   }
   public void setExecuteDate(DateTime executeDate) {
      this.executeDate = executeDate;
   }

   public DateTime getCreatedWhen() {
      return createdWhen;
   }
   public void setCreatedWhen(DateTime createdWhen) {
      this.createdWhen = createdWhen;
   }
   public void printBuisnessRecord() {
      System.out.println(getOriginalSentence() +
              "\nЗапланированное время выполнения задания: " + executeDate.getDateTimeString() +
              "\nВремя создания: " + createdWhen.getDateTimeString() + "\n");
   }

   @Override
   public int compareTo(BuisinessRecord o) {
      ZonedDateTime thisZoneDateTime = createdWhen.getDataTime().atZone(ZoneId.systemDefault());
      ZonedDateTime oZoneDateTime = o.createdWhen.getDataTime().atZone(ZoneId.systemDefault());

      long seconds1 =  thisZoneDateTime.toInstant().toEpochMilli()/1000;;
      long seconds2 =  oZoneDateTime.toInstant().toEpochMilli()/1000;;
      return (int) (seconds1 - seconds2);
   }

   @Override
   public int hashCode() {

      ZonedDateTime thisZoneDateTime = createdWhen.getDataTime().atZone(ZoneId.systemDefault());

      return (int) (thisZoneDateTime.toInstant().toEpochMilli()/1000) * 31;
   }
}
