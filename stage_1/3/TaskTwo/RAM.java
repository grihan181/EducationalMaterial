package com.company.TaskTwo;

public class RAM {
    private String name;
    private int size;


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

    public RAM(){
        this.name = "";
        this.size = 0;
    }
    public RAM(String name, int size) {
        this.name = name;
        this.size = size;
    }
}
