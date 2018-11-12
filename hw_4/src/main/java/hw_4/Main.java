package hw_4;

import hw_4.controller.CalcController;
import hw_4.view.CalcView;

public class Main {

    public static void main(String[] args) {

        CalcView calcView = new CalcView();
        CalcController calcController = new CalcController(calcView);

        calcController.mainMenu();
    }
}
