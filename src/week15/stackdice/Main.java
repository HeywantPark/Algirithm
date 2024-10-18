package week15.stackdice;

import java.util.Scanner;

public class Main {
    static int[] op = {5,3,4,1,2,0}; // 주사위의 마주보는 인덱스

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 주사위의 개수
        int[][] dice = new int[n][6]; // 주사위의 숫자 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();
            }
        }

        int maxSum = 0;

        // 주사위의 한 면을 바닥으로 설정하고 주사위를 쌓는 경우
        for (int i = 0; i < 6; i++) {
            int Sum = 0; // 양면의 최댓값을 더한 값
            int bottom = dice[0][i]; // 첫 주사위의 아랫면
            int top = dice[0][op[i]]; // 첫 주사위의 윗면

            // 첫 주사위에서 선택된 양면의 최댓값의 합
            Sum += getMaxSide(dice[0], top, bottom);

            // 나머지 주사위의 쌓기
            for (int j = 1; j < n; j++) {
                bottom = top;
                top = dice[j][op[findIndex(dice[j],bottom)]];

                Sum += getMaxSide(dice[j], top, bottom);
            }
            maxSum = Math.max(Sum, maxSum);
        }
        System.out.println(maxSum);

    }

    // 주사위의 옆면의 최댓값 구하기
    public static int getMaxSide(int[] dice, int top, int bottom) {
        int maxNum = 0;

        for (int i = 0; i < 6; i++) {
            // top 과 bottom 을 제외한 값 중에서 최댓값을 찾음
            if (dice[i] != top && dice[i] != bottom) {
                maxNum = Math.max(maxNum, dice[i]);
            }
        }
        return maxNum;
    }
    // top 인덱스 찾기
    public static int findIndex(int[] dice, int bottom) {
        for (int i = 0; i < 6; i++) {
            if (dice[i] == bottom) {
                return i; // top 인덱스
            }
        }
        return -1;
    }
}
