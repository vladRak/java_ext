package hw_4.controller;

import hw_3.exceptions.UncorrectedDataInputException;
import hw_3.utils.ConsoleViewHelper;
import hw_3.utils.ResourceBundleHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hw_4.util.Calc;
import hw_4.view.CalcView;

import java.io.IOException;
import java.util.Locale;

public class CalcController {

    private final CalcView view;
    private CalcResourceManager resourceManager;
    private final Logger logger = LoggerFactory.getLogger(CalcController.class.getName());

    public CalcController(CalcView view) {
        this.view = view;
        this.resourceManager = CalcResourceManager.INSTANCE;
    }

    public void mainMenu() {
        while (true) {
            try {
                selectLanguage(view
                        .choiceLanguage(ResourceBundleHelper
                                .getSupportedLanguages("calc")));
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
                view.showMessage(resourceManager.getString("message"));
                view.showMessage(resourceManager.getString("calculate"));
                view.showMessage(resourceManager.getString("result") + " " + Calc.eval(ConsoleViewHelper.readLine()));
            } catch (UncorrectedDataInputException e) {
                logger.error(e.getMessage());
                view.showMessage(e.getMessage());
            }
        }
    }

    public String selectLanguage(Locale locale) {
        resourceManager.changeResource(locale);
        logger.info("User select language: " + locale.getLanguage());
        return locale.getLanguage();
    }
}
