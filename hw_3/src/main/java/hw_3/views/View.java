package hw_3.views;

import hw_3.exceptions.UncorrectedDataInputException;
import hw_3.models.Vehicle;

import java.util.List;
import java.util.Locale;

public interface View {
// 1. Vehicles with the lowest price, highest speed, not older than 5 years.
// 2. Planes with an altitude above 5000, year of manufacture after 2000.
// 3. Vehicles (not Plane) with a maximum speed in the range of 200 - 500.
// 4. Vehicles with maximum speed from Flyable, MoveAble, SwimAble arrays.

    Locale choiceLanguage(List<String> languages);
    int mainMenu(List<String> menuItems) throws UncorrectedDataInputException;
    String lowPriceHigherSpeedNotOlderFiveYears(List<Vehicle> vehicles);
    String altitudeYearFilter(List<Vehicle> planes);
    String maxSpeedRangeWithOutPlanes(List<Vehicle> vehicles);
    String maxSpeedFromVehicleType(List<Vehicle> vehicles);
    String showMessage(String message);
}
