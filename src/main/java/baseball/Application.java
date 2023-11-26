package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        String human = String.valueOf(1);
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (Integer.parseInt(human) == 1) {
            // 랜덤 숫자 출력
            for (int i = 0; computer.size() < 3; i++) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            System.out.println("숫자를 입력해주세요 :");
            human = readLine();
            String[] hum = human.split("");

            if (Integer.parseInt(human) < 100 || Integer.parseInt(human) > 999) //숫자 값이 이상한 경우 에러 처리
                throw new IllegalArgumentException();

            int strike = 0;
            int ball = 0;
            //    List<Integer> names = new ArrayList<>(Arrays.asList(1,2,3));

            //계산 함수
            for (int i = 0; i < 3; i++) {
                if (hum[i].equals(String.valueOf(computer.get(i)))) {
                    strike++;
                    //System.out.println("strike!");
                }
                else {
                    for (int j = 0; j < 3; j++) {
                        if (hum[i].equals(String.valueOf(computer.get(j)))) {
                            ball++;
                            //System.out.println("ball!");
                        }
                    }

                }
            }
            //출력 조건 함수
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
                human = String.valueOf(1);
            } else if (ball == 0 && strike == 3) {
                System.out.printf("%d스트라이크", strike);
                System.out.println("3개의 숫자를 모두 맞히셨습니다!");
                System.out.println("게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                System.out.println(computer);
                computer.clear();
                human = readLine();

            } else {
                System.out.printf("%d볼 %d스트라이크", ball, strike);
                human = String.valueOf(1);
            }
        }
    }
}
