package hw_3.models.impl;

import hw_3.models.Flyable;
import hw_3.models.Relocation;
import hw_3.models.SwimAble;

public final class Batmobile extends Car implements Flyable, SwimAble {

    public final static Batmobile INSTANCE = new Batmobile.Builder().build();

    private final static float PRICE = 1 / 0.0f;
    private final static int YEAR_OF_MANUFACTURE = 2005;
    private final static int SPEED = 250;
    private final static Integer[] START_COORDINATES = {0, 0};
    private final static int NUMBER_OF_WHEELS = 4;
    private final static float ENGINE_CAPACITY = 5.7f;
    private final static float FLYING_SPEED_COEFFICIENT = 1.2f;
    private final static float SWIMMING_SPEED_COEFFICIENT = 0.6f;

    private static class Builder extends Car.Builder {

        public Builder() {
            super(PRICE, YEAR_OF_MANUFACTURE, SPEED, START_COORDINATES);
            super.numberOfWheels(NUMBER_OF_WHEELS)
                 .engineCapacity(ENGINE_CAPACITY);
        }

        @Override
        public Batmobile build() {
            return new Batmobile(this);
        }
    }

    private Batmobile(Builder builder) {
        super(builder);
    }

    @Override
    public Relocation fly() {
        int flyingSpeed = speedWithCoefficient(FLYING_SPEED_COEFFICIENT);
        return new RelocationParameters(flyingSpeed, getNextDisplacementCoordinates());
    }

    @Override
    public Relocation swim() {
        int swimmingSpeed = speedWithCoefficient(SWIMMING_SPEED_COEFFICIENT);
        return new RelocationParameters(swimmingSpeed, getNextDisplacementCoordinates());
    }

    private int speedWithCoefficient(float coefficient){
        return (int) (getSpeed() * coefficient);
    }

    @Override
    public String toString() {
        return "Batmobile{" + super.toString() + "}";
    }
}
