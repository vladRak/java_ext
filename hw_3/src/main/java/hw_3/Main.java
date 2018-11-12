package hw_3;

import hw_3.controllers.VehicleController;
import hw_3.controllers.impl.VehicleControllerImpl;
import hw_3.models.Vehicle;
import hw_3.models.impl.Batmobile;
import hw_3.models.impl.Plane;
import hw_3.services.VehicleService;
import hw_3.services.VehicleServiceImpl;
import hw_3.views.View;
import hw_3.views.impl.ViewImpl;

public class Main {

    public static void main(String[] args) {

        Vehicle batmob = Batmobile.INSTANCE;

        Vehicle plane = new Plane
                .Builder(120, 2016, 570, new Integer[]{1, 2})
                .heights(10000)
                .numberOfPassengers(100)
                .build();


        Vehicle plane2 = new Plane
                .Builder(150, 2015, 550, new Integer[]{1, 2})
                .heights(10000)
                .numberOfPassengers(100)
                .build();

        Vehicle plane3 = new Plane
                .Builder(120, 2017, 600, new Integer[]{1, 2})
                .heights(10000)
                .numberOfPassengers(100)
                .build();

        View view = new ViewImpl();
        VehicleService vehicleService = new VehicleServiceImpl();
        vehicleService.createVehicle(batmob);
        vehicleService.createVehicle(plane);
        vehicleService.createVehicle(plane2);
        vehicleService.createVehicle(plane3);

        VehicleController vehicleController = new VehicleControllerImpl(view, vehicleService);
        vehicleController.mainMenu();

    }


}
