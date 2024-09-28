package week13.binary;

import java.util.Scanner;

public class Main {
    public long solution(int n) {

        long[][] dp = new long[n + 1][2];

        // basecase
        dp[1][0] = 0; // 1자리 수에서 0으로 끝나는 경우
        dp[1][1] = 1; // 1자리 수에서 1로 끝나는 경우

        // dp 테이블 채우기
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; //0으로 끝나는 경우
            dp[i][1] = dp[i - 1][0];                //1로 끝나는 경우
        }
        return dp[n][0] + dp[n][1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Main main = new Main();
        System.out.println(main.solution(N));
    }
}
