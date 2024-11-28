package menu.domain.coach;

import java.util.List;

public class MenuValidator {

    public static boolean validate(List<String> menu, List<String> unWantedFoods, String food) {
        boolean flag = false;
        flag = containsUnwanted(menu, unWantedFoods, food);
        flag = isDuplicateFood(menu, food);

        return flag;
    }

    public static boolean isDuplicateFood(List<String> menu, String food) {
        if (menu.contains(food)) {
            return true;
        }
        return false;
    }

    public static boolean containsUnwanted(List<String> menu, List<String> unWantedFoods, String food) {
        for (String unWantedFood : unWantedFoods) {
            if (menu.contains(unWantedFood)) {
                return true;
            }
        }
        return false;
    }
}
