package hw_3.services;

import hw_3.models.Vehicle;
import hw_3.models.VehiclesTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleServiceImpl implements VehicleService {

    private Map<Integer, Vehicle> vehicles = new HashMap<>();

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicles();
    }

    @Override
    public List<Vehicle> deleteVehicleById(int id) {
        vehicles.remove(id);
        return vehicles();
    }

    public List<Vehicle> getVehiclesByType(VehiclesTypes vehiclesTypes) {

        List<Vehicle> vehiclesByType = new ArrayList<>();
        vehicles().stream().forEach
                (vehicle -> {
                    if (vehicle.getClass() == vehiclesTypes.getType()) {
                        vehiclesByType.add(vehicle);
                    }
                });
        return vehiclesByType;
    }

    @Override
    public List<Vehicle> getVehiclesByType() {
        return null;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return vehicles.get(id);
    }

    @Override
    public Vehicle changeVehicleCoordinates(int id, Integer[] coordinates) {
        Vehicle vehicle = vehicles.get(id);
        vehicle.addDisplacementCoordinates(coordinates);
        return vehicle;
    }

    private List<Vehicle> vehicles() {
        return convertMapToList(this.vehicles);
    }

    private List<Vehicle> convertMapToList(Map<Integer, Vehicle> vehicles) {
        return new ArrayList<>(vehicles.values());
    }
}
