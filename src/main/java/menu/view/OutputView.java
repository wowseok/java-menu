package menu.view;

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

    public void printUnWantedFoods(Coach coach) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.%n", coach);
    }

    /*public void printRecommandFoods() {
        System.out.printf("메뉴 추천 결과입니다.%n");
    }
     */

}
