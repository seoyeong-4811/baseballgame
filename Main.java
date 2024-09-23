import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> attemptsList = new ArrayList<>();
        int gameCount = 0;



        while (true) {
            System.out.println("원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int answer = scanner.nextInt();

            if (answer == 1) {
                gameCount++;
                BaseballGame game = new BaseballGame();
                int attempts = game.play(); // 게임 시작, 시도 횟수 받기
                attemptsList.add(attempts); // 시도 횟수 기록

            } else if (answer == 2) {
                System.out.println("< 게임 기록 보기 >");
                for (int i = 0; i < attemptsList.size(); i++) {
                    System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + attemptsList.get(i));
                }
                // 기록 보기
            } else if (answer == 3) {
                System.out.println("게임을 종료합니다!");
                break; // 프로그램 종료
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }
}