package week12.bridge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] site = new int[m + 1][n + 1];

            //basecase
            for (int j = 0; j <= m; j++) {
                site[j][0] = 0;
                site[0][j] = 0;
                if(j <= n) {
                    site[j][j] = 1;
                }
            }
            //dp 점화식 사용
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    site[j][k] = site[j-1][k-1] + site[j-1][k];
                }
            }
            System.out.println(site[m][n]);
        }
    }
}
