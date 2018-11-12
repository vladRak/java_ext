package hw_2;

public abstract class ComputerPart {
    private final String manufacturer;
    private final float supplyVoltage;
    private final float maximumPowerConsumption;

    public static abstract class Builder<T extends Builder<T>> {
        private String manufacturer;
        private float supplyVoltage;
        private float maximumPowerConsumption;

        public Builder(String manufacturer,
                       float supplyVoltage,
                       float maximumPowerConsumption) {
            this.manufacturer = manufacturer;
            this.supplyVoltage = supplyVoltage;
            this.maximumPowerConsumption = maximumPowerConsumption;
        }

        public abstract T getThis();
    }

    protected ComputerPart(Builder builder) {
        this.manufacturer = builder.manufacturer;
        this.supplyVoltage = builder.supplyVoltage;
        this.maximumPowerConsumption = builder.maximumPowerConsumption;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getSupplyVoltage() {
        return supplyVoltage;
    }

    public float getMaximumPowerConsumption() {
        return maximumPowerConsumption;
    }
}
