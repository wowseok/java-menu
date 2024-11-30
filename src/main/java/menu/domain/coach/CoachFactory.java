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

    private void restCoaches() {
        coaches.clear();
    }

    public void validate() {
        if (coaches.size() < 2 || coaches.size() > 5) {
            restCoaches();
            throw new IllegalArgumentException("코치는 최소 2명, 최대 5명입니다.");
        }
    }
}
