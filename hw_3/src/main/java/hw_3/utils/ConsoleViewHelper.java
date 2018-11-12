package hw_3.utils;

import hw_3.exceptions.UncorrectedDataInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleViewHelper {

    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final Logger logger = LoggerFactory.getLogger(ConsoleViewHelper.class.getName());

    public static int getSelectedMenuItem() throws UncorrectedDataInputException{
        return parseIntFromString(readLine());
    }

    public static int getSelectedMenuItemFromList(List list) throws UncorrectedDataInputException{
        final int ARRAY_DIFFERENT = 1;
        final int menuItem = getSelectedMenuItem();
        if (menuItem == 0)
            return 0;
        else if (list.size() >= menuItem){
            return menuItem - ARRAY_DIFFERENT;
        }else throw new UncorrectedDataInputException();
    }

    public static String printMessageToConsole(String message) {
        System.out.println(message);
        return message;
    }

    public static String readLine() throws UncorrectedDataInputException{
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new UncorrectedDataInputException();
        }
    }

    public static String buildMessageFromList(List objects) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < objects.size(); i++) {
            sb.append(i + 1 + " " + objects.get(i).toString());
            if (i < objects.size() - 1) sb.append("\n");
        }

        return sb.toString();
    }

    private static int parseIntFromString(String string) throws UncorrectedDataInputException{
            return parseInt(string);
    }

    private static int parseInt(String string) throws UncorrectedDataInputException {
        try {
           return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new UncorrectedDataInputException();
        }
    }
}
