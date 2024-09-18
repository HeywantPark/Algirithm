package week12.apartment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // 테스트 케이스 수

        for (int test = 0; test < t; test++) {
            int k = sc.nextInt(); // 층 수
            int n = sc.nextInt(); // 호 수

            int[][] memo = new int[k + 1][n + 1];

            // base case: 0층에는 i호에 i명 거주
            for (int i = 1; i <= n; i++) {
                memo[0][i] = i;
            }

            // dp로 memo 테이블 채우기
            for (int i = 1; i <= k; i++) { // 층
                for (int j = 1; j <= n; j++) { // 호
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }

            // 결과 출력
            System.out.println(memo[k][n]);
        }
    }
}
