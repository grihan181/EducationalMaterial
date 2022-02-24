package com.company.TaskTwo;

public class TaskTwo {
    public static void main(String[] args) {
        HardDrive hardDrive = new HardDrive("Seagate Barracuda", 1024, 156);
        RAM ram = new RAM("Corsair Vengeance", 32);
        CPU cpu = new CPU("Intel Core i3 10100F", 3.6);
        Computer comp = new Computer(hardDrive,ram,cpu);
        comp.switchOn();
        System.out.println(comp.checkOnVirus());
        comp.printSizeOfHDAndRAM();
        System.out.println("\n");
        comp.printVirusInfo();
        comp.switchOff();
    }
}
