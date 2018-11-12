package hw_3.views.impl;

import hw_3.exceptions.UncorrectedDataInputException;
import hw_3.models.Vehicle;
import hw_3.utils.ConsoleViewHelper;
import hw_3.views.View;

import java.util.List;
import java.util.Locale;

public class ViewImpl implements View {

    @Override
    public Locale choiceLanguage(List<String> languages) {
        showMessage(choiceLanguageMessage(languages));

        return new Locale(languages.get(ConsoleViewHelper.getSelectedMenuItemFromList(languages)));
    }

    private String choiceLanguageMessage(List<String> languages) {
        return "Please choice language for menu: \n" + ConsoleViewHelper.buildMessageFromList(languages);
    }

    @Override
    public int mainMenu(List<String> menuItems) throws UncorrectedDataInputException {
        showMessage(ConsoleViewHelper.buildMessageFromList(menuItems));

        return ConsoleViewHelper.getSelectedMenuItemFromList(menuItems);
    }

    @Override
    public String lowPriceHigherSpeedNotOlderFiveYears(List<Vehicle> vehicles) {
        String message = "Vehicles with the lowest price," +
                " highest speed, not older than " +
                "5 years: \n" + ConsoleViewHelper.buildMessageFromList(vehicles);
        showMessage(message);
        return message;
    }

    @Override
    public String altitudeYearFilter(List<Vehicle> planes) {
        String message = "Planes with an altitude above 5000," +
                " year of manufacture after 2000: \n" +
                ConsoleViewHelper.buildMessageFromList(planes);
        showMessage(message);
        return message;
    }

    @Override
    public String maxSpeedRangeWithOutPlanes(List<Vehicle> vehicles) {
        String message = "Vehicles (not Plane) with a maximum" +
                " speed in the range of 200 - 500: \n" +
                ConsoleViewHelper.buildMessageFromList(vehicles);
        showMessage(message);
        return message;
    }

    @Override
    public String maxSpeedFromVehicleType(List<Vehicle> vehicles) {
        String message = "Vehicles with maximum speed from" +
                " Flyable, MoveAble, SwimAble arrays: \n" +
                ConsoleViewHelper.buildMessageFromList(vehicles);
        showMessage(message);
        return message;
    }

    @Override
    public String showMessage(String message) {
        ConsoleViewHelper.printMessageToConsole(message);
        return message;
    }
}
