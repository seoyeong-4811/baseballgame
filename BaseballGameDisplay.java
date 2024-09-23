public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        if (strike > 0) {
            System.out.print(strike + " 스트라이크");
        }
        if (ball > 0) {
            System.out.print((strike > 0 ? " " : "") + ball + " 볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else {
            System.out.println();
        }
    }
}
