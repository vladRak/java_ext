package java_ext.hw_2.impl;

import java_ext.hw_2.ComponentWithMemory;
import java_ext.hw_2.ComputerPart;

public class HardDrive extends ComputerPart implements ComponentWithMemory {

    private final int hardDriveCapacity;
//    Емкость накопителя 1 ТБ

    private final String manufacturerCode;
    //    Код производителя    WD10EZEX
    private final String typeHardDrive;
    //   Тип жесткого диска  Внутренний
    private final String technology;

    //    Технология         HDD
    private final float formFactor;
    //    Форм-фактор 3.5"
    private final String connectionInterface;
//    Интерфейс SATAIII

    private final int spindleSpeed;
    //    Скорость вращения шпинделя 7200 об/мин
    private final int bufferCapacity;
    //   Объем буфера 64 МБ
    private final int dataTransferRate;
    //    Скорость передачи данных 6 Гб/с
    private final int maximumNoiseLevel;
    //    Максимальный уровень шума 30 дБ


//    Максимальная потребляемая мощность 6.8 Вт

    public static class Builder extends ComputerPart.Builder<Builder> {

        private int hardDriveCapacity;
        private String manufacturerCode;
        private String typeHardDrive;
        private String technology;
        private float formFactor;
        private String connectionInterface;
        private int spindleSpeed;
        private int bufferCapacity;
        private int dataTransferRate;
        private int maximumNoiseLevel;

        public Builder(String manufacturer,
                       float supplyVoltage,
                       float maximumPowerConsumption) {
            super(manufacturer, supplyVoltage, maximumPowerConsumption);
        }

        public Builder hardDriveCapacity(int hardDriveCapacity) {
            this.hardDriveCapacity = hardDriveCapacity;
            return this;
        }

        public Builder manufacturerCode(String manufacturerCode) {
            this.manufacturerCode = manufacturerCode;
            return this;
        }

        public Builder typeHardDrive(String typeHardDrive) {
            this.typeHardDrive = typeHardDrive;
            return this;
        }

        public Builder technology(String technology) {
            this.technology = technology;
            return this;
        }

        public Builder formFactor(float formFactor) {
            this.formFactor = formFactor;
            return this;
        }

        public Builder connectionInterface(String connectionInterface) {
            this.connectionInterface = connectionInterface;
            return this;
        }

        public Builder spindleSpeed(int spindleSpeed) {
            this.spindleSpeed = spindleSpeed;
            return this;
        }

        public Builder bufferCapacity(int bufferCapacity) {
            this.bufferCapacity = bufferCapacity;
            return this;
        }

        public Builder dataTransferRate(int dataTransferRate) {
            this.dataTransferRate = dataTransferRate;
            return this;
        }

        public Builder maximumNoiseLevel(int maximumNoiseLevel) {
            this.maximumNoiseLevel = maximumNoiseLevel;
            return this;
        }

        @Override
        public Builder getThis() {
            return this;
        }

        public HardDrive build() {
            return new HardDrive(this);
        }
    }

    private HardDrive(Builder builder) {
        super(builder);
        this.hardDriveCapacity = builder.hardDriveCapacity;
        this.manufacturerCode = builder.manufacturerCode;
        this.typeHardDrive = builder.typeHardDrive;
        this.technology = builder.technology;
        this.formFactor = builder.formFactor;
        this.connectionInterface = builder.connectionInterface;
        this.spindleSpeed = builder.spindleSpeed;
        this.bufferCapacity = builder.bufferCapacity;
        this.dataTransferRate = builder.dataTransferRate;
        this.maximumNoiseLevel = builder.maximumNoiseLevel;
    }

    @Override
    public boolean checkMemory() {
        return false;
    }

    public int getHardDriveCapacity() {
        return hardDriveCapacity;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public String getTypeHardDrive() {
        return typeHardDrive;
    }

    public String getTechnology() {
        return technology;
    }

    public float getFormFactor() {
        return formFactor;
    }

    public String getConnectionInterface() {
        return connectionInterface;
    }

    public int getSpindleSpeed() {
        return spindleSpeed;
    }

    public int getBufferCapacity() {
        return bufferCapacity;
    }

    public int getDataTransferRate() {
        return dataTransferRate;
    }

    public int getMaximumNoiseLevel() {
        return maximumNoiseLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardDrive)) return false;

        HardDrive hardDrive = (HardDrive) o;

        if (getHardDriveCapacity() != hardDrive.getHardDriveCapacity()) return false;
        if (Float.compare(hardDrive.getFormFactor(), getFormFactor()) != 0) return false;
        if (getSpindleSpeed() != hardDrive.getSpindleSpeed()) return false;
        if (getBufferCapacity() != hardDrive.getBufferCapacity()) return false;
        if (getDataTransferRate() != hardDrive.getDataTransferRate()) return false;
        if (getMaximumNoiseLevel() != hardDrive.getMaximumNoiseLevel()) return false;
        if (getManufacturerCode() != null ? !getManufacturerCode().equals(hardDrive.getManufacturerCode()) : hardDrive.getManufacturerCode() != null)
            return false;
        if (getTypeHardDrive() != null ? !getTypeHardDrive().equals(hardDrive.getTypeHardDrive()) : hardDrive.getTypeHardDrive() != null)
            return false;
        if (getTechnology() != null ? !getTechnology().equals(hardDrive.getTechnology()) : hardDrive.getTechnology() != null)
            return false;
        return getConnectionInterface() != null ? getConnectionInterface().equals(hardDrive.getConnectionInterface()) : hardDrive.getConnectionInterface() == null;
    }

    @Override
    public int hashCode() {
        int result = getHardDriveCapacity();
        result = 31 * result + (getManufacturerCode() != null ? getManufacturerCode().hashCode() : 0);
        result = 31 * result + (getTypeHardDrive() != null ? getTypeHardDrive().hashCode() : 0);
        result = 31 * result + (getTechnology() != null ? getTechnology().hashCode() : 0);
        result = 31 * result + (getFormFactor() != +0.0f ? Float.floatToIntBits(getFormFactor()) : 0);
        result = 31 * result + (getConnectionInterface() != null ? getConnectionInterface().hashCode() : 0);
        result = 31 * result + getSpindleSpeed();
        result = 31 * result + getBufferCapacity();
        result = 31 * result + getDataTransferRate();
        result = 31 * result + getMaximumNoiseLevel();
        return result;
    }

    @Override
    public String toString() {
        return "HardDrive: " + "\n" +
                "Manufacturer: " + super.getManufacturer() + "\n" +
                "Hard drive capacity: " + hardDriveCapacity + "\n" +
                "Manufacturer code: " + manufacturerCode + "\n" +
                "Type hard drive: " + typeHardDrive + "\n" +
                "Technology: " + technology + "\n" +
                "Form factor: " + formFactor + "\n" +
                "Connection interface: " + connectionInterface + "\n" +
                "Spindle speed: " + spindleSpeed + "\n" +
                "Buffer capacity: " + bufferCapacity + "\n" +
                "Data transfer rate: " + dataTransferRate + "\n" +
                "Maximum noise level: " + maximumNoiseLevel + "\n" +
                "Supply voltage: " + super.getSupplyVoltage() + "\n" +
                "Maximum Power Consumption: " + super.getMaximumPowerConsumption() + "\n";
    }
}
