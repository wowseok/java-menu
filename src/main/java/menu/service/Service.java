package menu.service;

import java.util.List;
import menu.Day;
import menu.domain.category.Category;
import menu.domain.category.SelectedCategory;
import menu.domain.coach.Coach;
import menu.domain.coach.CoachFactory;
import menu.view.OutputView;

public class Service {


    public void setUp(String input) {
        String[] coachNames = input.split(",", -1);
        CoachFactory coachFactory = CoachFactory.getInstance();
        for (String coachName : coachNames) {
            coachFactory.createCoach(coachName);
        }
        coachFactory.validate();
    }

    public void menuRecommendService() {
        SelectedCategory selectedCategory = new SelectedCategory();
        for (int i = 0; i < Day.values().length; i++) {
            selectedCategory.addCategory(Category.getCategory());
        }
        OutputView.printCategory(selectedCategory.getCategories());
        List<Category> categories = selectedCategory.getCategories();

        CoachFactory coachFactory = CoachFactory.getInstance();
        for (Category category : categories) {
            for (Coach coach : coachFactory.getCoaches()) {
                coach.setMenu(category);
            }
        }

    }

}
