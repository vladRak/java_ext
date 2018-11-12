package hw_2.impl;

import hw_2.ComputerPart;

public class CentralProcessingUnit extends ComputerPart {

    private final String familyCPU;
    private final String nameCPU;
    private final String socketCPU;
    private final int coreClockFrequency;
    private final int numberOfCores;
    private final int cacheLevel1;
    private final int cacheLevel2;
    private final int cacheLevel3;

    public static class Builder extends ComputerPart.Builder<Builder> {

        private String familyCPU;
        private String nameCPU;
        private String socketCPU;
        private int coreClockFrequency;
        private int numberOfCores;
        private int cacheLevel1;
        private int cacheLevel2;
        private int cacheLevel3;

        public Builder(String manufacturer,
                       float supplyVoltage,
                       float maximumPowerConsumption) {
            super(manufacturer, supplyVoltage, maximumPowerConsumption);
        }

        public Builder familyCPU(String familyCPU) {
            this.familyCPU = familyCPU;
            return this;
        }

        public Builder nameCPU(String nameCPU) {
            this.nameCPU = nameCPU;
            return this;
        }

        public Builder socketCPU(String socketCPU) {
            this.socketCPU = socketCPU;
            return this;
        }

        public Builder coreClockFrequency(int coreClockFrequency) {
            this.coreClockFrequency = coreClockFrequency;
            return this;
        }

        public Builder numberOfCores(int numberOfCores) {
            this.numberOfCores = numberOfCores;
            return this;
        }

        public Builder cacheLevel1(int cacheLevel1) {
            this.cacheLevel1 = cacheLevel1;
            return this;
        }

        public Builder cacheLevel2(int cacheLevel2) {
            this.cacheLevel2 = cacheLevel2;
            return this;
        }

        public Builder cacheLevel3(int cacheLevel3) {
            this.cacheLevel3 = cacheLevel3;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        public CentralProcessingUnit build() {
            return new CentralProcessingUnit(this);
        }
    }

    private CentralProcessingUnit(Builder builder) {
        super(builder);
        this.familyCPU = builder.familyCPU;
        this.nameCPU = builder.nameCPU;
        this.socketCPU = builder.socketCPU;
        this.coreClockFrequency = builder.coreClockFrequency;
        this.numberOfCores = builder.numberOfCores;
        this.cacheLevel1 = builder.cacheLevel1;
        this.cacheLevel2 = builder.cacheLevel2;
        this.cacheLevel3 = builder.cacheLevel3;
    }

    public String getFamilyCPU() {
        return familyCPU;
    }

    public String getNameCPU() {
        return nameCPU;
    }

    public String getSocketCPU() {
        return socketCPU;
    }

    public int getCoreClockFrequency() {
        return coreClockFrequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public int getCacheLevel1() {
        return cacheLevel1;
    }

    public int getCacheLevel2() {
        return cacheLevel2;
    }

    public int getCacheLevel3() {
        return cacheLevel3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CentralProcessingUnit)) return false;

        CentralProcessingUnit that = (CentralProcessingUnit) o;

        if (getCoreClockFrequency() != that.getCoreClockFrequency()) return false;
        if (getNumberOfCores() != that.getNumberOfCores()) return false;
        if (getCacheLevel3() != that.getCacheLevel3()) return false;
        if (getFamilyCPU() != null ? !getFamilyCPU().equals(that.getFamilyCPU()) : that.getFamilyCPU() != null)
            return false;
        if (getNameCPU() != null ? !getNameCPU().equals(that.getNameCPU()) : that.getNameCPU() != null) return false;
        return getSocketCPU() != null ? getSocketCPU().equals(that.getSocketCPU()) : that.getSocketCPU() == null;
    }

    @Override
    public int hashCode() {
        int result = getFamilyCPU() != null ? getFamilyCPU().hashCode() : 0;
        result = 31 * result + (getNameCPU() != null ? getNameCPU().hashCode() : 0);
        result = 31 * result + (getSocketCPU() != null ? getSocketCPU().hashCode() : 0);
        result = 31 * result + getCoreClockFrequency();
        result = 31 * result + getNumberOfCores();
        result = 31 * result + getCacheLevel3();
        result = 31 * result + Float.hashCode(super.getSupplyVoltage());
        return result;
    }

    @Override
    public String toString() {
        return "hw_2.impl.CentralProcessingUnit: " + "\n" +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Family CPU: '" + familyCPU + "\n" +
                "Name CPU: " + nameCPU + "\n" +
                "Socket: '" + socketCPU + "\n" +
                "Number of cores: " + numberOfCores + "\n" +
                "Core clock frequency: " + coreClockFrequency + "\n" +
                "Cache Level 1: " + cacheLevel1 + "\n" +
                "Cache Level 2: " + cacheLevel2 + "\n" +
                "Cache Level 3: " + cacheLevel3 + "\n" +
                "Supply voltage: " + super.getSupplyVoltage() + "\n" +
                "Maximum Power Consumption: " + super.getMaximumPowerConsumption() + "\n";
    }
}