package menu.domain.category;

import java.util.ArrayList;
import java.util.List;

public class SelectedCategory {

    private final List<Category> categories;

    public SelectedCategory() {
        this.categories = new ArrayList<>();
    }


    public void addCategory(Category category) {
        while (CategoryValidator.isLimit(categories, category)) {
            category = Category.getCategory();
        }
        categories.add(category);

    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }


}
