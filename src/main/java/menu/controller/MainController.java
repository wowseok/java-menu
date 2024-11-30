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
        service.setUp(InputView.readLine());
    }

    private void inputUnwantedFoods() {
        CoachFactory coachFactory = CoachFactory.getInstance();
        for (int i = 0; i < coachFactory.getCoaches().size(); i++) {
            outputView.printUnWantedFoods(coachFactory.getCoaches().get(i));
            String[] unWantedFoods = InputView.readLine().split(",", -1);
            for (String food : unWantedFoods) {
                coachFactory.getCoaches().get(i).setUnWantedFoods(food);
            }
        }
    }

    private void recommendResult() {
        outputView.printResultMessage();
        service.menuRecommendService();
        CoachFactory coachFactory = CoachFactory.getInstance();
        outputView.printCoachMenu(coachFactory.getCoaches());
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
