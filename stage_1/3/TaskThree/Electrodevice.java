package com.company.TaskThree;

public class Electrodevice implements Comparable<Electrodevice> {
    private int wattage;
    private int status;

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
    public int getWattage() {
        return wattage;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Electrodevice() {
        this.wattage = 0;
        this.status = 0;
    }
    public Electrodevice(int wattage) {
        this.wattage = wattage;
        this.status = 0;
    }

    public void switchOn(){
        this.status = 1;
        System.out.println("Electrodevice is ON.");
    }
    public void switchOff(){
        this.status = 0;
        System.out.println("Electrodevice is OFF.");
    }
    public String getStatusString() {
        if (status == 0) {
            return "Electrodevice is off";
        }
        return "Electrodevice is on";
    }

    @Override
    public int compareTo(Electrodevice o) {
        return this.getWattage() - o.getWattage();
    }
}
