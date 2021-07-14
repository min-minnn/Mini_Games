import java.util.*;

public class Game {
    Scanner input = new Scanner(System.in);
    int a, b, result;
    int count = 0; //총 점수

    int randomGame() {
        while (true) {
            a = (int)(Math.random() * 9) + 1; //1~9 사이의 랜덤 값
            b = (int)(Math.random() * 9) + 1; //1~9 사이의 랜덤 값
            int answer = a * b; //입력한 값과 비교할 정답

            System.out.println(a + "×" + b + "= ?");
            System.out.print(">> ");
            result = input.nextInt(); //입력한 값을 int형으로 받아옴

            if(result == answer) { //answer과 비교했을 때 입력한 값이 동일한지 판별
                System.out.println("정답입니다.");
                count += 10; //정답이면 10점씩 점수 증가
                randomGame(); //재 호출
           }else{
                System.out.println("오답입니다.");
                break;
            }
            break;
        }
        return count;
    }

    void upDownGame() {
        a = (int)(Math.random() * 100) + 1;
        while (true) {
            System.out.println("숫자를 입력해 주세요.(1~100)");
            System.out.print(">> ");
            b = input.nextInt();

            if(a == b){
                count++;
                System.out.println(a + "이/가 맞습니다. 총" + count + "번만에 맞추셨습니다.");
                break;
            } else if(a < b) {
                System.out.println("Down");
                count++;
            }else if(a > b) {
                System.out.println("Up");
                count++;
            }else{
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int num;

        Game g = new Game();

        System.out.println("----------< 게임을 선택해 주세요.(숫자 입력) >----------");
        System.out.println("1. 구구단 게임");
        System.out.println("2. UP & Down Game");
        System.out.print(">> ");
        num = input.nextInt();

        switch (num) {
            case 1: System.out.println("총 점수는 " + g.randomGame() + "점입니다.");
                    break;
            case 2: g.upDownGame();
                    break;
            default: System.out.println("잘못 입력하셨습니다.");
                    break;
        }
    }
}