package com.company.TaskTwo;

public class HardDrive {
    private String name;
    private int size;
    private int speed;


    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public HardDrive(){
        this.name = "";
        this.size = 0;
        this.speed = 0;
    }
    public HardDrive(String name, int size, int speed) {
        this.name = name;
        this.size = size;
        this.speed = speed;
    }
}
