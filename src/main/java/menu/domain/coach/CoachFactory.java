package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class CoachFactory {
    private final List<Coach> coaches;
    private static final CoachFactory INSTANCE = new CoachFactory();

    public static CoachFactory getInstance() {
        return INSTANCE;
    }

    CoachFactory() {
        this.coaches = new ArrayList<>();
    }

    public void createCoach(String name) {
        coaches.add(new Coach(name));
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
