package java_ext.hw_2.impl;

import java_ext.hw_2.ComponentWithMemory;
import java_ext.hw_2.ComputerPart;

public class RandomAccessMemory extends ComputerPart implements ComponentWithMemory {
    private final int memoryCapacity;
    private final String memoryType;
    private final int memoryClockFrequency;
    private final int effectiveBandwidth;

    public static class Builder extends ComputerPart.Builder<Builder> {

        private int memoryCapacity;
        private String memoryType;
        private int memoryClockFrequency;
        private int effectiveBandwidth;

        public Builder(String manufacturer,
                       float supplyVoltage,
                       float maximumPowerConsumption) {
            super(manufacturer, supplyVoltage, maximumPowerConsumption);
        }

        public Builder memoryCapacity(int memoryCapacity) {
            this.memoryCapacity = memoryCapacity;
            return this;
        }

        public Builder memoryType(String memoryType) {
            this.memoryType = memoryType;
            return this;
        }

        public Builder memoryClockFrequency(int memoryClockFrequency) {
            this.memoryClockFrequency = memoryClockFrequency;
            return this;
        }

        public Builder effectiveBandwidth(int effectiveBandwidth) {
            this.effectiveBandwidth = effectiveBandwidth;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        public RandomAccessMemory build() {
            return new RandomAccessMemory(this);
        }
    }

    private RandomAccessMemory(Builder builder) {
        super(builder);
        this.memoryCapacity = builder.memoryCapacity;
        this.memoryType = builder.memoryType;
        this.memoryClockFrequency = builder.memoryClockFrequency;
        this.effectiveBandwidth = builder.effectiveBandwidth;
    }

    public int getMemoryCapacity() {
        return memoryCapacity;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public int getMemoryClockFrequency() {
        return memoryClockFrequency;
    }

    public int getEffectiveBandwidth() {
        return effectiveBandwidth;
    }

    @Override
    public boolean checkMemory() {
        return false;
    }

    //    Максимальная потребляемая мощность 6.8 Вт

//    Эффективная пропускная способность
//12800 Мб/с


    @Override
    public String toString() {
        return "RandomAccessMemory: " + "\n" +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Memory capacity: " + memoryCapacity + "\n" +
                "Memory type: " + memoryType + "\n" +
                "Memory clock frequency: " + memoryClockFrequency + "\n" +
                "Effective band width: " + effectiveBandwidth + "\n" +
                "Supply voltage: " + super.getSupplyVoltage() + "\n" +
                "Maximum Power Consumption: " + super.getMaximumPowerConsumption();
    }
}
