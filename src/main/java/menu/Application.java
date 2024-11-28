package menu;

import menu.controller.MainController;
import menu.service.Service;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new Service(), new OutputView());
        mainController.run();
    }
}
