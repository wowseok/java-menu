package menu.domain.coach;

import java.util.ArrayList;
import java.util.List;
import menu.domain.category.Category;

public class Coach {
    private final String name;
    private final List<String> unWantedFoods;
    private final List<String> menu;

    Coach(String name) {
        nameValidate(name);
        this.name = name;
        this.unWantedFoods = new ArrayList<>();
        this.menu = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }


    public void setUnWantedFoods(String food) {
        validate();
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

    public void nameValidate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException("코치의 이름은 최소 2글자, 최대 4글자입니다.");
        }
    }

    private void validate() {
        checkQuantity();
    }

    private void checkQuantity() {
        if (unWantedFoods.size() > 2) {
            throw new IllegalArgumentException("먹지 못하는 음식 수는 최대 2개입니다.");
        }
    }

}
