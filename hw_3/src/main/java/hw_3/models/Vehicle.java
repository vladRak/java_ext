package hw_3.models;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Vehicle {

//    private final int price;
    private final int id;
    private final float price;
    private final int yearOfManufacture;
    private final int speed;
    private Integer[] currentCoordinates;
    private Queue<Integer[]> displacementCoordinates;

    protected static abstract class Builder<B extends Builder<B>> {
        private int id;
        private static int currentId = 0;
        private float price;
        private int yearOfManufacture;
        private int speed;
        private Integer[] currentCoordinates;
        private Queue<Integer[]> displacementCoordinates = new LinkedList<>();

        public Builder(float price,
                       int yearOfManufacture,
                       int speed, Integer[] startCoordinates) {
            this.id = idGenerator();
            this.price = price;
            this.yearOfManufacture = yearOfManufacture;
            this.speed = speed;
            this.currentCoordinates = startCoordinates;
        }

        public Builder displacementCoordinates(Queue<Integer[]> displacementCoordinates) {
            this.displacementCoordinates = displacementCoordinates;
            return this;
        }

        public abstract Vehicle build();
    }

    protected Vehicle(Builder builder) {
        this.id = builder.id;
        this.price = builder.price;
        this.yearOfManufacture = builder.yearOfManufacture;
        this.speed = builder.speed;
        this.currentCoordinates = builder.currentCoordinates;
        this.displacementCoordinates = builder.displacementCoordinates;
    }

    public int getId(){
        return id;
    }

    public float getPrice() {
        return price;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getSpeed() {
        return speed;
    }

    public Integer[] getCurrentCoordinates() {
        return currentCoordinates;
    }

    public Queue<Integer[]> getRoute() {
        return displacementCoordinates;
    }

    public Integer[] getNextDisplacementCoordinates() throws NullPointerException {
        return displacementCoordinates.peek();
    }

    public Queue<Integer[]> addDisplacementCoordinates(Integer[] coordinates) {
        displacementCoordinates.add(coordinates);
        return displacementCoordinates;
    }

    protected Integer[] replace() {
        return currentCoordinates = displacementCoordinates.poll();
    }

    private static int idGenerator(){
        return ++Builder.currentId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", price=" + price +
                ", yearOfManufacture=" + yearOfManufacture +
                ", speed=" + speed +
                ", currentCoordinates=" + Arrays.toString(currentCoordinates) +
                ", displacementCoordinates=" + displacementCoordinates +
                '}';
    }
}