package menu.service;

import menu.domain.coach.CoachFactory;

public class Service {

    public void setUp(String input) {
        String[] coachNames = input.split(",", -1);
        CoachFactory coachFactory = CoachFactory.getInstance();
        for (String coachName : coachNames) {
            coachFactory.createCoach(coachName);
        }
    }

}
