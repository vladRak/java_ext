package hw_2;

import hw_2.impl.CentralProcessingUnit;
import hw_2.impl.RandomAccessMemory;

public class Main {

    public static void main(String[] args) {

        CentralProcessingUnit cpu = new CentralProcessingUnit
                .Builder("Intel",1.5F,5F)
                .familyCPU("Ololo")
                .socketCPU("S100500")
                .cacheLevel3(650)
                .coreClockFrequency(2000)
                .numberOfCores(9)
                .build();

        System.out.println(cpu);

        RandomAccessMemory ram = new RandomAccessMemory
                .Builder("Kingstone", 1.5F, 6.8F)
                .effectiveBandwidth(12800)
                .memoryCapacity(4000)
                .memoryClockFrequency(665)
                .memoryType("DDR3")
                .build();
        System.out.println(ram);

        Computer computer = new Computer.ComputerBuilder(cpu,ram).build();

        System.out.println(computer);

        computer.turnOff();
        computer.turnOn();
        computer.turnOn();
        computer.hardDriveCapacityCheck();
        computer.virusCheck();
        computer.turnOff();
        computer.hardDriveCapacityCheck();

        computer.virusCheck();
        computer.hardDriveCapacityCheck();
    }
}
