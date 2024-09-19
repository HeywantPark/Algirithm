package week12.bridge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // 테스트 케이스 개수 입력

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();  // 서쪽 사이트 개수 (N)
            int m = sc.nextInt();  // 동쪽 사이트 개수 (M)

            int[][] site = new int[m + 1][n + 1];  // DP 배열 초기화

            // 기본 케이스 설정
            for (int j = 0; j <= m; j++) {
                site[j][0] = 1;  // 다리 0개를 놓는 경우
                if(j <= n) {
                    site[j][j] = 1;  // 다리 개수와 사이트 개수가 같을 때
                }
            }

            // DP 점화식
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    site[j][k] = site[j-1][k-1] + site[j-1][k];  // 조합 계산
                }
            }

            System.out.println(site[m][n]);  // 결과 출력
        }
        sc.close();
    }
}
