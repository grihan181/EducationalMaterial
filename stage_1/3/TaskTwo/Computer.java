package com.company.TaskTwo;

import java.util.Random;

public class Computer {
    private HardDrive hardDrive;
    private RAM ram;
    private CPU cpu;

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }
    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }
    public RAM getRam() {
        return ram;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }
    public CPU getCpu() {
        return cpu;
    }

    public Computer() {
        this.hardDrive = new HardDrive();
        this.ram = new RAM();
        this.cpu = new CPU();
    }
    public Computer(HardDrive hardDrive, RAM ram, CPU cpu) {
        this.hardDrive = hardDrive;
        this.ram = ram;
        this.cpu = cpu;
    }

    public void switchOn(){
        System.out.println("Computer is ON.");
    }
    public void switchOff(){
        System.out.println("Computer is OFF.");
    }

    public boolean checkOnVirus() {
        int virus =  1 + (int) (Math.random() *2);
        if (virus == 1) {
            return false;
        } else  {
            return true;
        }

    }
    public void printSizeOfHDAndRAM() {
        System.out.printf("Размер винчестера: %d\nОперативной памяти: %d", hardDrive.getSize(), ram.getSize());
    }
    public void printVirusInfo() {
        if (!checkOnVirus()) {
            System.out.println("Вирусов нет.");
        } else {
            System.out.println("Вирусы есть!");
        }
    }
}
