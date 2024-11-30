package menu.controller;

import menu.domain.coach.CoachFactory;
import menu.service.Service;
import menu.view.InputView;
import menu.view.OutputView;

public class MainController {
    private final OutputView outputView;
    private final Service service;

    public MainController(Service service, OutputView outputView) {
        this.service = service;
        this.outputView = outputView;
    }

    public void run() {
        process(this::inputCoachNames);
        process(this::inputUnwantedFoods);
        process(this::recommendResult);
    }

    private void inputCoachNames() {
        outputView.printIntroMessage();
        service.setUpCoaches(InputView.readLine());
    }

    private void inputUnwantedFoods() {
        service.setUpFoods();
    }

    private void recommendResult() {
        outputView.printResultMessage();
        service.menuRecommendService();
        outputView.printCoachMenu(CoachFactory.getInstance().getCoaches());
        outputView.endMessage();
    }


    private void process(Runnable action) {
        try {
            action.run();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            process(action);
        }
    }
}
