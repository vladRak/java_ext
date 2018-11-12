package hw_3.controllers.impl;

import hw_3.controllers.VehicleController;
import hw_3.controllers.impl.utils.ResourceManager;
import hw_3.exceptions.UncorrectedDataInputException;
import hw_3.listeners.ChoiceListener;
import hw_3.models.Vehicle;
import hw_3.services.VehicleService;
import hw_3.utils.ResourceBundleHelper;
import hw_3.utils.VehicleFilterBuilder;
import hw_3.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class VehicleControllerImpl implements VehicleController {

    private final View view;
    private final VehicleService vehicleService;
    private final ChoiceListener choiceListener;
    private ResourceManager resourceManager;
    private final Logger logger = LoggerFactory.getLogger(VehicleControllerImpl.class.getName());

    public VehicleControllerImpl(View view, VehicleService vehicleService) {
        this.view = view;
        this.vehicleService = vehicleService;
        this.resourceManager = ResourceManager.INSTANCE;
        this.choiceListener = new ChoiceListener(this, resourceManager.getResourceBundle());
    }

    public ChoiceListener getChoiceListener() {
        return choiceListener;
    }

    @Override
    public void mainMenu() {
        while (true) {
            try {
                selectLanguage(view
                        .choiceLanguage(ResourceBundleHelper
                                .getSupportedLanguages("menu")));
                break;
            } catch (UncorrectedDataInputException e) {
                logger.error(e.getMessage());
                view.showMessage(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                choiceListener.listen(callViewMainMenu());
            } catch (UncorrectedDataInputException e) {
                logger.error(e.getMessage());
                view.showMessage(e.getMessage());
            }
        }
    }

    private String callViewMainMenu() {
        int numberItem = view.mainMenu(getMenuItems());
        return getMenuItems().get(numberItem);
    }

    @Override
    public String selectLanguage(Locale locale) {
        resourceManager.changeResource(locale);
        choiceListener.setResourceBundle(resourceManager.getResourceBundle());
        logger.info("User select language: " + locale.getLanguage());
        return locale.getLanguage();
    }

    private List<String> getMenuItems() {
        return resourceManager.keySet()
                .stream()
                .map(rbk -> resourceManager.getString(rbk))
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> lowPriceHighestSpeed() {
        List<Vehicle> vehicles = new VehicleFilterBuilder
                .Builder(vehicleService.getVehicles())
                .newestThanAge(5)
                .minPriceMaxSpeed()
                .build()
                .getVehicles();

        view.lowPriceHigherSpeedNotOlderFiveYears(vehicles);
        return vehicles;
    }

    @Override
    public List<Vehicle> planesAltitudeAbove5000() {
        List<Vehicle> planes = new VehicleFilterBuilder
                .Builder(vehicleService.getVehicles())
                .planeAltitudeFilter(5000)
                .newestThanAge(2000)
                .build()
                .getVehicles();

        view.altitudeYearFilter(planes);
        return planes;
    }

    @Override
    public List<Vehicle> notPlaneMaxSpeed() {
        List<Vehicle> vehicles = new VehicleFilterBuilder
                .Builder(vehicleService.getVehicles())
                .excludePlanes()
                .moreThanSpeed(200)
                .lessThanSpeed(500)
                .maxSpeedSorted()
                .build()
                .getVehicles();

        view.maxSpeedRangeWithOutPlanes(vehicles);
        return vehicles;
    }

    @Override
    public List<Vehicle> maxSpeedByType() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(maxSpeedByFlyable());
        vehicles.add(maxSpeedByMoveAble());
        vehicles.add(maxSpeedBySwimAble());

        view.maxSpeedFromVehicleType(vehicles);
        return vehicles;
    }

    private Vehicle maxSpeedByFlyable() {
        List<Vehicle> vehicles = new VehicleFilterBuilder
                .Builder(vehicleService.getVehicles())
                .flyableFilter()
                .maxSpeed()
                .build()
                .getVehicles();
        return vehicles.get(0);
    }

    private Vehicle maxSpeedByMoveAble() {
        List<Vehicle> vehicles = new VehicleFilterBuilder
                .Builder(vehicleService.getVehicles())
                .moveAbleFilter()
                .maxSpeed()
                .build()
                .getVehicles();

        return vehicles.get(0);
    }

    private Vehicle maxSpeedBySwimAble() {
        List<Vehicle> vehicles = new VehicleFilterBuilder
                .Builder(vehicleService.getVehicles())
                .swiwAbleFilter()
                .maxSpeed()
                .build()
                .getVehicles();
        return vehicles.get(0);
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
