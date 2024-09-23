import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BaseballGame {
    private final String answer; // 정답을 저장할 필드

    // 객체 생성 시 정답을 생성
    public BaseballGame() {
        answer = correctAnswer(); // 게임 시작전 정답 먼저 생성 !
        System.out.println("< 게임을 시작합니다 >");
    }

    private String correctAnswer() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }

        // 리스트 섞기
        Collections.shuffle(digits);

        // 첫 3개 숫자를 정답으로 선택
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(digits.get(i));
        }

        return sb.toString();
    }

    public int play() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (true) {
            System.out.print("1~9 까지의 3자리 숫자를 입력하세요: ");
            String input = scanner.nextLine();
            attempts++; // 숫자 입력시 시도 횟수 증가

            if (!validateInput(input)) {
                System.out.println("올바른 입력값이 아닙니다. (0, 문자, 중복되는 숫자 => 사용 불가)");

                continue;
            }

            int strike = countStrike(input);
            int ball = countBall(input);

            if (strike == 3) {
                System.out.println("정답입니다! 시도 횟수: " + attempts);
                return attempts;

            } else {
                // 힌트 출력
                BaseballGameDisplay display = new BaseballGameDisplay();
                display.displayHint(strike, ball);
            }
        }

    }

    // 입력값 유효성 검사
    protected boolean validateInput(String input) {
        if (input.length() != 3) {
            return false; // 3자리 이상 불가
        } else {
            HashSet<Character> set = new HashSet<>();
            for (char c : input.toCharArray()) {
                if (!Character.isDigit(c) || c == '0' || !set.add(c)) {
                    return false; // 0 , 문자, 중복된 숫자 사용 불가
                }
            }
        }
        return true;
    }

    // 스트라이크 메서드
    private int countStrike(String input) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    // 볼 메서드
    private int countBall(String input) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            char currentChar = input.charAt(i);
            for (int j = 0; j < 3; j++) {
                if (currentChar == answer.charAt(j) && i != j) {
                    ballCount++;
                }
            }

        } return ballCount;
    }
}






