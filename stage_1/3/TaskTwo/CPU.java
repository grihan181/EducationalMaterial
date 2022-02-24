package com.company.TaskTwo;

public class CPU {
    private String name;
    private double frequency;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public CPU() {
        this.name = "";
        this.frequency = 0;
    }
    public CPU(String name, double frequency) {
        this.name = name;
        this.frequency = frequency;
    }
}
