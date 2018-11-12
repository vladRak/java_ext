package hw_3.controllers;

import hw_3.models.Vehicle;

import java.util.List;
import java.util.Locale;

public interface VehicleController {

    void mainMenu();
    String selectLanguage(Locale locale);
    List<Vehicle> lowPriceHighestSpeed();
    List<Vehicle> planesAltitudeAbove5000();
    List<Vehicle> notPlaneMaxSpeed();
    List<Vehicle> maxSpeedByType();
    void exit();

//    List<Vehicle> getVehicles();
//    List<Vehicle> sortVehicles();
//    List<Vehicle> groupVehicles();
//    List<Vehicle> deleteVehicle(int id);
//
//    void typeOfVehicle();
//    void parametersOfVehicle();
//    Vehicle createVehicle();
//    void cancelCreatingVehicle();
//
//    void back();
}
