package week26.pipe;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] house;
    static int count = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        house = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                house[i][j] = sc.nextInt();
            }
        }
        dfs(0,1,0);
        System.out.println(count);

    }
    private static void dfs(int r, int c, int v) {

        if (r == n - 1 && c == n - 1) {
            count++;
            return;
        }
        if (v == 0 || v == 2) { // 가로로 갈 수 있는 경우
            if(c + 1 < n && house[r][c + 1] == 0) {
                dfs(r, c+1, 0);
            }
        }
        if (v == 1 || v == 2) { // 세로로 갈 수 있는 경우
            if(r + 1 < n && house[r+ 1][c] == 0) {
                dfs(r + 1, c, 1);
            }
        }
        if (v == 0 || v == 1 || v == 2) { // 대각선으로 갈 수 있는 경우
            if(r + 1 < n && c + 1 < n && house[r + 1][c + 1] == 0
            && house[r][c + 1] == 0
            && house[r + 1][c] == 0) {
                dfs(r + 1, c + 1, 2);
            }
        }
    }
}
