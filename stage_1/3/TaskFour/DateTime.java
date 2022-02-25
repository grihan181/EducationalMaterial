package com.company.TaskFour;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateTime {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy/HH:mm:ss");
    private String DataTimeString;
    private LocalDateTime DataTime;


    public String getDateTimeString() {
        DataTimeString  = dtf.format(DataTime);
        return DataTimeString;
    }

    public void setDateTimeString(LocalDateTime DataTime) {
        DataTimeString  = dtf.format (DataTime);
    }

    public LocalDateTime getDataTime() {
        return DataTime;
    }
    public void setDateTime(String text) {
        try {
            DataTime = LocalDateTime.parse(text, dtf);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Введен неправильный формат");
        }
    }


    public LocalDateTime getDataTimeFromString(String text) {
        return LocalDateTime.parse(text, dtf);
    }

    public void setDateTimeNow() {
        DataTime = LocalDateTime.now();
    }
    public String getDateTimeStringNow() {
        DataTimeString  = dtf.format (LocalDateTime.now());
        return DataTimeString;
    }
    public LocalDateTime getDateTimeNow() {
        DataTimeString  = dtf.format (LocalDateTime.now());
        return LocalDateTime.now();
    }


}
