package hw_4.view;

import hw_3.utils.ConsoleViewHelper;

import java.util.List;
import java.util.Locale;

public class CalcView {

    public Locale choiceLanguage(List<String> languages) {
        showMessage(choiceLanguageMessage(languages));

        return new Locale(languages.get(ConsoleViewHelper.getSelectedMenuItemFromList(languages)));
    }

    private String choiceLanguageMessage(List<String> languages) {
        return "Please choice language for menu: \n" + ConsoleViewHelper.buildMessageFromList(languages);
    }

    public String showMessage(String message) {
        ConsoleViewHelper.printMessageToConsole(message);
        return message;
    }
}
