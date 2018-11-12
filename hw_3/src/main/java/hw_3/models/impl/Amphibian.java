package hw_3.models.impl;

import hw_3.models.Relocation;
import hw_3.models.SwimAble;

public class Amphibian extends Car implements SwimAble {

    private final static float SWIMMING_SPEED_COEFFICIENT = 0.3f;
    private final int numberOfPassengers;

    private static class Builder extends Car.Builder {

        private int numberOfPassengers;

        public Builder(int price,
                       int yearOfManufacture,
                       int speed,
                       Integer[] startCoordinates) {
            super(price, yearOfManufacture, speed, startCoordinates);
        }

        public Builder numberOfPassengers(int numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
            return this;
        }

        @Override
        public Amphibian build() {
            return new Amphibian(this);
        }
    }

    private Amphibian(Builder builder) {
        super(builder);
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    @Override
    public Relocation swim() {
        int swimmingSpeed = speedWithCoefficient(SWIMMING_SPEED_COEFFICIENT);
        return new RelocationParameters(swimmingSpeed, getNextDisplacementCoordinates());
    }

    private int speedWithCoefficient(float coefficient) {
        return (int) (getSpeed() * coefficient);
    }

    @Override
    public String toString() {
        return "Batmobile{" + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amphibian)) return false;

        Amphibian amphibian = (Amphibian) o;

        return numberOfPassengers == amphibian.numberOfPassengers;
    }

    @Override
    public int hashCode() {
        return numberOfPassengers;
    }
}
