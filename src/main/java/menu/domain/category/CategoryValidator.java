package menu.domain.category;

import java.util.List;

public class CategoryValidator {

    public static void validate(List<Category> categories, Category category) {
        isLimit(categories, category);
    }


    public static boolean isLimit(List<Category> categories, Category category) {
        int count = 0;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).equals(category)) {
                count += 1;
            }
        }
        if (count >= 2) {
            return true;
        }
        return false;
    }
}
