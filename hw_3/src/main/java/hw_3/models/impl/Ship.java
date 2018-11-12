package hw_3.models.impl;

import hw_3.models.Relocation;
import hw_3.models.SwimAble;
import hw_3.models.Vehicle;

import java.util.Queue;

public class Ship<B extends Ship<B>> extends Vehicle implements SwimAble {

    private final String portOfRegistry;
    private final int numberOfPassengers;

    public static class Builder<B extends Ship.Builder<B>> extends Vehicle.Builder<B> {

        private String portOfRegistry;
        private int numberOfPassengers;

        public Builder(int price,
                       int yearOfManufacture,
                       int speed,
                       Integer[] startCoordinates) {
            super(price, yearOfManufacture, speed, startCoordinates);
        }

        public Builder portOfRegistry(String portOfRegistry) {
            this.portOfRegistry = portOfRegistry;
            return this;
        }

        public Builder numberOfPassengers(int numberOfPassengers) {
            this.numberOfPassengers = numberOfPassengers;
            return this;
        }

        public Builder displacementCoordinates(Queue<Integer[]> displacementCoordinates) {
            super.displacementCoordinates(displacementCoordinates);
            return this;
        }

        public Ship build() {
            return new Ship(this);
        }
    }

    private Ship(Builder builder) {
        super(builder);
        this.portOfRegistry = builder.portOfRegistry;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    @Override
    public Relocation swim() {
        return new RelocationParameters(getSpeed(), getNextDisplacementCoordinates());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;

        Ship<?> ship = (Ship<?>) o;

        if (numberOfPassengers != ship.numberOfPassengers) return false;
        return portOfRegistry != null ? portOfRegistry.equals(ship.portOfRegistry) : ship.portOfRegistry == null;
    }

    @Override
    public int hashCode() {
        int result = portOfRegistry != null ? portOfRegistry.hashCode() : 0;
        result = 31 * result + numberOfPassengers;
        return result;
    }
}
