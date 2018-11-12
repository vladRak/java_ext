package hw_3.utils;

import hw_3.models.Flyable;
import hw_3.models.MoveAble;
import hw_3.models.SwimAble;
import hw_3.models.Vehicle;
import hw_3.models.impl.Plane;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class VehicleFilterBuilder {

    private final List<Vehicle> vehicles;

    public static class Builder {

        private List<Vehicle> vehicles;

        public Builder(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
        }

        public Builder lessThanPrice(int price) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> vehicle.getPrice() < price)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder moreThanPrice(int price) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> vehicle.getPrice() > price)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder lessThanSpeed(int speed) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> vehicle.getSpeed() < speed)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder moreThanSpeed(int speed) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> vehicle.getSpeed() > speed)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder newestThanAge(int age) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> ageOfVehicle(vehicle.getYearOfManufacture()) < age)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder oldestThanAge(int age) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> ageOfVehicle(vehicle.getYearOfManufacture()) > age)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder minPriceMaxSpeed() {
            this.vehicles = vehicles
                    .stream()
                    .sorted(Comparator.comparingDouble(Vehicle::getPrice)
                            .thenComparing(Comparator.comparingInt(Vehicle::getSpeed).reversed()))
                    .collect(Collectors.toList());
            return this;
        }

        public Builder minPrice() {
            this.vehicles = vehicles
                    .stream()
                    .sorted(Comparator.comparingDouble(Vehicle::getPrice))
                    .collect(Collectors.toList());
            return this;
        }

        public Builder moveAbleFilter() {
            this.vehicles = vehicles
                    .stream().filter(vehicle -> vehicle instanceof MoveAble)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder flyableFilter() {
            this.vehicles = vehicles
                    .stream().filter(vehicle -> vehicle instanceof Flyable)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder swiwAbleFilter() {
            this.vehicles = vehicles
                    .stream().filter(vehicle -> vehicle instanceof SwimAble)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder planeAltitudeFilter(int altitude) {
            this.vehicles = vehicles
                    .stream()
                    .filter(vehicle -> vehicle instanceof Plane)
                    .map(vehicle -> (Plane) vehicle)
                    .filter(vehicle -> vehicle.getHeights() > altitude)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder excludePlanes() {
            this.vehicles = vehicles
                    .stream().filter(vehicle -> !(vehicle instanceof Plane))
                    .collect(Collectors.toList());
            return this;
        }

        public Builder maxSpeed() {
            this.vehicles = arrayFromVehicle(
                    vehicles
                            .stream()
                            .max(Comparator.comparingInt(Vehicle::getSpeed))
                            .orElseThrow(NoSuchElementException::new));
            return this;
        }

        public Builder maxSpeedSorted() {
            this.vehicles = vehicles
                    .stream()
                    .sorted(Comparator.comparingInt(Vehicle::getSpeed).reversed())
                    .collect(Collectors.toList());
            return this;
        }

        public VehicleFilterBuilder build() {
            return new VehicleFilterBuilder(this);
        }
    }

    private VehicleFilterBuilder(Builder builder) {
        this.vehicles = builder.vehicles;
    }

    private static int ageOfVehicle(int yearOfManufacture) {
        int year = Year.now().getValue();
        return year - yearOfManufacture;
    }

    private static List<Vehicle> arrayFromVehicle(Vehicle vehicle) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        return vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
