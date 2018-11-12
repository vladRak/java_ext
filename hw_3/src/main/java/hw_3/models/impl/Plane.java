package hw_3.models.impl;

import hw_3.models.Flyable;
import hw_3.models.Relocation;
import hw_3.models.Vehicle;
import java.util.Queue;

public class Plane<B extends Plane<B>> extends Vehicle implements Flyable {

    private final int heights;
    private final int numberOfPassengers;

    public static class Builder<B extends Plane.Builder<B>> extends Vehicle.Builder<B> {

        private int heights;
        private int numberOfPassengers;

        public Builder(int price,
                       int yearOfManufacture,
                       int speed,
                       Integer[] startCoordinates) {
            super(price, yearOfManufacture, speed, startCoordinates);
        }

        public Builder heights(int heights) {
            this.heights = heights;
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

        public Plane build() {
            return new Plane(this);
        }
    }

    private Plane(Builder builder) {
        super(builder);
        this.heights = builder.heights;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    public int getHeights() {
        return heights;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    @Override
    public Relocation fly() {
        return new RelocationParameters(getSpeed(),getNextDisplacementCoordinates());
    }

    @Override
    public String toString() {
        return "Plane{" +
                "heights=" + heights +
                ", numberOfPassengers=" + numberOfPassengers +
                super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane<?> plane = (Plane<?>) o;

        if (getHeights() != plane.getHeights()) return false;
        return getNumberOfPassengers() == plane.getNumberOfPassengers();
    }

    @Override
    public int hashCode() {
        int result = getHeights();
        result = 31 * result + getNumberOfPassengers();
        return result;
    }
}
