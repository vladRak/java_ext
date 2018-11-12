package hw_3.services;

import hw_3.models.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle getVehicleById(int id);
    Vehicle changeVehicleCoordinates(int id, Integer[] coordinates);
    List<Vehicle> getVehicles();
    List<Vehicle> deleteVehicleById(int id);
    List<Vehicle> getVehiclesByType();
}
