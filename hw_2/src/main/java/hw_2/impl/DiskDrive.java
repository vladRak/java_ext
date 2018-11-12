package hw_2.impl;

import hw_2.ComponentWithMemory;
import hw_2.ComputerPart;

import java.util.HashMap;
import java.util.Set;

public class DiskDrive extends ComputerPart implements ComponentWithMemory {

    private final String manufacturerCode;
    private final String typeDiskDrive;
    private final String classDiskDrive;
    private final Set<String> supportedFormats;

    private final HashMap<String, Integer> writeSpeed;
    private final HashMap<String, Integer> readSpead;
    private final String connectionInterface;
    private boolean haseDisk = false;

    public static class Builder extends ComputerPart.Builder<Builder> {

        private String manufacturerCode;
        private String typeDiskDrive;
        private String classDiskDrive;
        private Set<String> supportedFormats;
        private HashMap<String, Integer> writeSpeed;
        private HashMap<String, Integer> readSpead;
        private String connectionInterface;


        public Builder(String manufacturer,
                       float supplyVoltage,
                       float maximumPowerConsumption) {
            super(manufacturer, supplyVoltage, maximumPowerConsumption);
        }

        public Builder manufacturerCode(String manufacturerCode) {
            this.manufacturerCode = manufacturerCode;
            return this;
        }

        public Builder typeDiskDrive(String typeDiskDrive) {
            this.typeDiskDrive = typeDiskDrive;
            return this;
        }

        public Builder classDiskDrive(String classDiskDrive) {
            this.classDiskDrive = classDiskDrive;
            return this;
        }

        public Builder supportedFormats(Set<String> supportedFormats) {
            this.supportedFormats = supportedFormats;
            return this;
        }

        public Builder writeSpeed(HashMap<String, Integer> writeSpeed) {
            this.writeSpeed = writeSpeed;
            return this;
        }

        public Builder readSpead(HashMap<String, Integer> readSpead) {
            this.readSpead = readSpead;
            return this;
        }

        public Builder connectionInterface(String connectionInterface) {
            this.connectionInterface = connectionInterface;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        public DiskDrive build() {
            return new DiskDrive(this);
        }
    }

    private DiskDrive(Builder builder) {
        super(builder);
        this.manufacturerCode = builder.manufacturerCode;
        this.typeDiskDrive = builder.typeDiskDrive;
        this.classDiskDrive = builder.classDiskDrive;
        this.supportedFormats = builder.supportedFormats;
        this.writeSpeed = builder.writeSpeed;
        this.readSpead = builder.readSpead;
        this.connectionInterface = builder.connectionInterface;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public String getTypeDiskDrive() {
        return typeDiskDrive;
    }

    public String getClassDiskDrive() {
        return classDiskDrive;
    }

    public Set<String> getSupportedFormats() {
        return supportedFormats;
    }

    public HashMap<String, Integer> getWriteSpeed() {
        return writeSpeed;
    }

    public String getConnectionInterface() {
        return connectionInterface;
    }

    public HashMap<String, Integer> getReadSpead() {
        return readSpead;
    }

    public void insertDisk() {
        haseDisk = true;
    }

    public void ejectDisk() {
        haseDisk = false;
    }

    @Override
    public boolean checkMemory() {
        if (haseDisk) return false;
        else {
            System.out.println("No disk in disk driver");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiskDrive)) return false;

        DiskDrive diskDrive = (DiskDrive) o;

        if (getManufacturerCode() != null ? !getManufacturerCode().equals(diskDrive.getManufacturerCode()) : diskDrive.getManufacturerCode() != null)
            return false;
        if (getTypeDiskDrive() != null ? !getTypeDiskDrive().equals(diskDrive.getTypeDiskDrive()) : diskDrive.getTypeDiskDrive() != null)
            return false;
        if (getClassDiskDrive() != null ? !getClassDiskDrive().equals(diskDrive.getClassDiskDrive()) : diskDrive.getClassDiskDrive() != null)
            return false;
        if (getSupportedFormats() != null ? !getSupportedFormats().equals(diskDrive.getSupportedFormats()) : diskDrive.getSupportedFormats() != null)
            return false;
        if (getWriteSpeed() != null ? !getWriteSpeed().equals(diskDrive.getWriteSpeed()) : diskDrive.getWriteSpeed() != null)
            return false;
        if (getReadSpead() != null ? !getReadSpead().equals(diskDrive.getReadSpead()) : diskDrive.getReadSpead() != null)
            return false;
        return getConnectionInterface() != null ? getConnectionInterface().equals(diskDrive.getConnectionInterface()) : diskDrive.getConnectionInterface() == null;
    }

    @Override
    public int hashCode() {
        int result = getManufacturerCode() != null ? getManufacturerCode().hashCode() : 0;
        result = 31 * result + (getTypeDiskDrive() != null ? getTypeDiskDrive().hashCode() : 0);
        result = 31 * result + (getClassDiskDrive() != null ? getClassDiskDrive().hashCode() : 0);
        result = 31 * result + (getSupportedFormats() != null ? getSupportedFormats().hashCode() : 0);
        result = 31 * result + (getWriteSpeed() != null ? getWriteSpeed().hashCode() : 0);
        result = 31 * result + (getReadSpead() != null ? getReadSpead().hashCode() : 0);
        result = 31 * result + (getConnectionInterface() != null ? getConnectionInterface().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "hw_2.impl.DiskDrive: " +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Manufacturer code: " + manufacturerCode + "\n" +
                "Type disk drive: " + typeDiskDrive + "\n" +
                "Class disk drive: " + classDiskDrive + "\n" +
                "Supported formats: " + supportedFormats + "\n" +
                "Write speed: " + writeSpeed + "\n" +
                "Read spead: " + readSpead + "\n" +
                "Connection interface: " + connectionInterface + "\n" +
                "Supply voltage: " + super.getSupplyVoltage() + "\n" +
                "Maximum Power Consumption: " + super.getMaximumPowerConsumption() + "\n";
    }
}
