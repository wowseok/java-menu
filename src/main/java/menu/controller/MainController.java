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
    }

    private void inputCoachNames() {
        outputView.printIntroMessage();
        service.setUp(InputView.readLine());
    }

    private void inputUnwantedFoods() {
        CoachFactory coachFactory = CoachFactory.getInstance();
        for (int i = 0; i < coachFactory.getCoaches().size(); i++) {
            outputView.printUnWantedFoods(coachFactory.getCoaches().get(i));
            coachFactory.getCoaches().get(i).setUnWantedFoods(InputView.readLine());
        }
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
