package hw_3.models.impl;

import hw_3.models.MoveAble;
import hw_3.models.Relocation;
import hw_3.models.Vehicle;

public class Car<B extends Car<B>> extends Vehicle implements MoveAble{

    private final int numberOfWheels;
    private final float engineCapacity;

    protected static class Builder<B extends Car.Builder<B>> extends Vehicle.Builder<B> {

        private int numberOfWheels;
        private float engineCapacity;

        public Builder(float price,
                       int yearOfManufacture,
                       int speed,
                       Integer[] startCoordinates) {
            super(price, yearOfManufacture, speed, startCoordinates);
        }

        public Builder numberOfWheels(int numberOfWheels) {
            this.numberOfWheels = numberOfWheels;
            return this;
        }

        public Builder engineCapacity(float engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

//        public Builder displacementCoordinates(Queue<Integer[]> displacementCoordinates) {
//            super.displacementCoordinates(displacementCoordinates);
//            return this;
//        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }

    protected Car(Builder builder) {
        super(builder);
        this.numberOfWheels = builder.numberOfWheels;
        this.engineCapacity = builder.engineCapacity;
    }

    @Override
    public Relocation move() {
        return new RelocationParameters(getSpeed(),getNextDisplacementCoordinates());
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfWheels=" + numberOfWheels +
                ", engineCapacity=" + engineCapacity +
                super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car<?> car = (Car<?>) o;

        if (numberOfWheels != car.numberOfWheels) return false;
        return Float.compare(car.engineCapacity, engineCapacity) == 0;
    }

    @Override
    public int hashCode() {
        int result = numberOfWheels;
        result = 31 * result + (engineCapacity != +0.0f ? Float.floatToIntBits(engineCapacity) : 0);
        return result;
    }
}