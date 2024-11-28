package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.category.Category;

public class Coach {
    private final String name;
    private final List<String> unWantedFoods;
    private final List<String> menu;

    Coach(String name) {
        this.name = name;
        this.unWantedFoods = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }


    public void setUnWantedFoods(String food) {
        this.unWantedFoods.add(food);
    }

    public List<String> getUnWantedFoods() {
        return unWantedFoods;
    }

    public void setMenu(Category category) {
        String food = category.getMenu();
        while (MenuValidator.validate(this.menu, unWantedFoods, food)) {
            food = category.getMenu();
        }
        this.menu.add(food);
    }

    public List<String> getMenu() {
        return this.menu;
    }

    @Override
    public String toString() {
        return name;
    }

}
