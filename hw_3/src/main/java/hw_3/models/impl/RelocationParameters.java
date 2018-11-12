package hw_3.models.impl;

import hw_3.models.Relocation;

import java.util.Arrays;

public class RelocationParameters implements Relocation{

    private final int speed;
    private final Integer[] coordinates;

    public RelocationParameters(int speed, Integer[] coordinates) {
        this.speed = speed;
        this.coordinates = coordinates;
    }

    public int getSpeed() {
        return speed;
    }

    public Integer[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "RelocationParameters{" +
                "speed=" + speed +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelocationParameters)) return false;

        RelocationParameters that = (RelocationParameters) o;

        if (getSpeed() != that.getSpeed()) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getCoordinates(), that.getCoordinates());
    }

    @Override
    public int hashCode() {
        int result = getSpeed();
        result = 31 * result + Arrays.hashCode(getCoordinates());
        return result;
    }


}
