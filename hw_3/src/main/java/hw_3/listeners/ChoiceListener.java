package hw_3.listeners;

import hw_3.controllers.VehicleController;

import java.util.ResourceBundle;

public class ChoiceListener {
    private final VehicleController controller;
    private ResourceBundle resourceBundle;

    public ChoiceListener(VehicleController controller, ResourceBundle resourceBundle){
         this.controller = controller;
         this.resourceBundle = resourceBundle;
    }

    public void listen(String event){
        if (event.equals(resourceBundle.getString("menu_low_price_hight_speed"))){
            controller.lowPriceHighestSpeed();
        }else if (event.equals(resourceBundle.getString("menu_planes_altitude_above_5000"))){
            controller.planesAltitudeAbove5000();
        }else if (event.equals(resourceBundle.getString("menu_not_plane_max_speed"))){
            controller.notPlaneMaxSpeed();
        }else if (event.equals(resourceBundle.getString("menu_max_speed_by_type"))){
            controller.maxSpeedByType();
        }else if (event.equals(resourceBundle.getString("menu_exit"))){
            controller.exit();
        }else controller.mainMenu();
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle){
        this.resourceBundle = resourceBundle;
    }
}