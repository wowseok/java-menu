package menu.view;

import java.util.List;
import menu.Day;
import menu.domain.category.Category;
import menu.domain.coach.Coach;

public class OutputView {

    public static final String ERROR_FORM = "[ERROR] %s%n";

    public void printErrorMessage(Throwable throwable) {
        System.out.printf(ERROR_FORM, throwable.getMessage());
        System.out.println();
    }

    public void printIntroMessage() {
        System.out.printf("점심 메뉴 추천을 시작합니다.%n%n");
        System.out.printf("코치의 이름을 입력해 주세요. (, 로 구분)%n");
    }

    public static void printUnWantedFoods(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach);
    }

    public void printResultMessage() {
        System.out.printf("메뉴 추천 결과입니다.%n");
        printDays();
    }

    public void printDays() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ 구분 | ");
        Day[] days = Day.values();
        for (int i = 0; i < days.length; i++) {
            sb.append(days[i].getDay());
            if (i < days.length - 1) { // 마지막 값이 아니면 구분자 추가
                sb.append(" | ");
            }
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void printCategory(List<Category> categories) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ 카테고리 | ");
        for (int i = 0; i < categories.size(); i++) {
            sb.append(categories.get(i).getName());
            if (i < categories.size() - 1) { // 마지막 값이 아니면 구분자 추가
                sb.append(" | ");
            }
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void printCoachMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("[ %s | ", coach.getName()));
            for (int i = 0; i < coach.getMenu().size(); i++) {
                sb.append(coach.getMenu().get(i));
                if (i < coach.getMenu().size() - 1) {
                    sb.append(" | ");
                }
            }
            sb.append(" ]");
            System.out.println(sb.toString());
        }
    }

    public static void endMessage() {
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }


}
