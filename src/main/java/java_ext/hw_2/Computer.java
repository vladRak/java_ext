package java_ext.hw_2;

import java_ext.hw_2.impl.CentralProcessingUnit;
import java_ext.hw_2.impl.DiskDrive;
import java_ext.hw_2.impl.HardDrive;
import java_ext.hw_2.impl.RandomAccessMemory;

import java.util.HashSet;
import java.util.Set;

public class Computer {

    private final CentralProcessingUnit centralProcessingUnit;
    private final RandomAccessMemory randomAccessMemory;
    private final HardDrive hardDrive;
    private final DiskDrive diskDrive;
    private boolean isTurnOn = false;

    public static class ComputerBuilder {
        private final CentralProcessingUnit centralProcessingUnit;
        private final RandomAccessMemory randomAccessMemory;
        private HardDrive hardDrive = null;
        private DiskDrive diskDrive = null;

        public ComputerBuilder(CentralProcessingUnit centralProcessingUnit,
                               RandomAccessMemory randomAccessMemory) {
            this.centralProcessingUnit = centralProcessingUnit;
            this.randomAccessMemory = randomAccessMemory;
        }

        public ComputerBuilder hardDrive(HardDrive hardDrive) {
            this.hardDrive = hardDrive;
            return this;
        }

        public ComputerBuilder diskDrive(DiskDrive diskDrive) {
            this.diskDrive = diskDrive;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    private Computer(ComputerBuilder computerBuilder) {
        centralProcessingUnit = computerBuilder.centralProcessingUnit;
        randomAccessMemory = computerBuilder.randomAccessMemory;
        hardDrive = computerBuilder.hardDrive;
        diskDrive = computerBuilder.diskDrive;
    }

    public CentralProcessingUnit getCentralProcessingUnit() {
        return centralProcessingUnit;
    }

    public RandomAccessMemory getRandomAccessMemory() {
        return randomAccessMemory;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public DiskDrive getDiskDrive() {
        return diskDrive;
    }

    private void printPowerStatus() {
        if (isTurnOn == true) {
            System.out.println("Computer working.");
        } else {
            System.out.println("Computer doesn't working.");
        }
    }

    public void turnOn() {
        if (isTurnOn) {
            printPowerStatus();
        } else {
            isTurnOn = true;
            System.out.println("Starting...");
        }
    }

    public void turnOff() {
        if (!isTurnOn) {
            printPowerStatus();
        } else {
            isTurnOn = false;
            System.out.println("Power off...");
        }
    }

    private Set<ComputerPart> checkInstaledParts() {
        Set<ComputerPart> instaledParts = new HashSet<>();
        instaledParts.add(centralProcessingUnit);
        instaledParts.add(randomAccessMemory);
        instaledParts.add(hardDrive);
        instaledParts.add(diskDrive);

        return instaledParts;
    }

    public void virusCheck() {
        if (isTurnOn) {
            for (ComputerPart cp : checkInstaledParts()) {
                if (cp instanceof ComponentWithMemory) {
                    if (!((ComponentWithMemory) cp).checkMemory())
                        System.out.println(cp.getClass().getSimpleName() + " clean.");
                } else if (cp instanceof ComponentWithMemory)
                    System.out.println(cp.getClass().getSimpleName() + " has virus.");
            }
        } else printPowerStatus();
    }

    public void hardDriveCapacityCheck() {
        if (isTurnOn) {
            if (hardDrive != null) System.out.println(hardDrive.getHardDriveCapacity());
            else System.out.println("Hard drive does'n exist.");
        }else printPowerStatus();
    }

    @Override
    public String toString() {
        return "Computer:" + "\n" +
                centralProcessingUnit + "\n" +
                randomAccessMemory + "\n" +
                hardDrive + "\n" +
                diskDrive + "\n";
    }
}
