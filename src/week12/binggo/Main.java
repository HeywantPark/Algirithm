package week12.binggo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int[][] binggo = new int[5][5];  // 빙고판 숫자를 저장하는 배열
    private static boolean[][] marked = new boolean[5][5];  // 마킹된 숫자를 확인하는 배열
    private static List<Integer> callNumbers = new ArrayList<>();  // 사회자가 부른 숫자 리스트

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                binggo[i][j] = sc.nextInt();
            }
        }

        // 사회자가 부르는 숫자 입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                callNumbers.add(sc.nextInt());
            }
        }

        // 부른 숫자에 따라 처리
        for (int turn = 0; turn < callNumbers.size(); turn++) {
            int number = callNumbers.get(turn);
            markedNumber(number);  // 숫자를 마킹
            if (checkBingo() >= 3) {  // 빙고 3줄 이상 체크
                System.out.println(turn + 1);  // 몇 번째 숫자에서 빙고가 되는지 출력 (1-based index)
                break;
            }
        }
    }

    // 숫자를 마킹하는 메서드
    static void markedNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (binggo[i][j] == number) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    // 빙고 여부를 체크하는 메서드
    static int checkBingo() {
        int count = 0;

        // 가로줄 체크
        for (int i = 0; i < 5; i++) {
            if (isBingo(marked[i])) count++;
        }

        // 세로줄 체크
        for (int j = 0; j < 5; j++) {
            boolean verticalBingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    verticalBingo = false;
                    break;
                }
            }
            if (verticalBingo) count++;
        }

        // 왼쪽 위에서 오른쪽 아래 대각선 체크
        boolean diagonal1 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                diagonal1 = false;
                break;
            }
        }
        if (diagonal1) count++;

        // 오른쪽 위에서 왼쪽 아래 대각선 체크
        boolean diagonal2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                diagonal2 = false;
                break;
            }
        }
        if (diagonal2) count++;

        return count;
    }

    // 한 줄이 모두 마킹되었는지 확인하는 메서드
    static boolean isBingo(boolean[] line) {
        for (boolean marked : line) {
            if (!marked) return false;  // 한 칸이라도 마킹되지 않았다면 빙고 아님
        }
        return true;
    }
}
