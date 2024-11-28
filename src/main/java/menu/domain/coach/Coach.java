package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private final List<String> unwantedFoods;

    Coach(String name) {
        this.name = name;
        this.unwantedFoods = new ArrayList<>();
    }


    public void setUnWantedFoods(String food) {
        unwantedFoods.add(food);
    }

    public List<String> getUnwantedFoods() {
        return unwantedFoods;
    }

    @Override
    public String toString() {
        return name;
    }

}
