package week21.robotvacuum;

import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int startRow = sc.nextInt();
        int startCol = sc.nextInt();
        int distance = sc.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n][m];
        dfs(startRow,startCol,distance,matrix);
        System.out.println(count);
    }
    private static void dfs(int row, int col, int dir,int[][] matrix) {
        // 현재 칸 청소
        if (!visited[row][col]) {
            visited[row][col] = true;
            count++;
        }

        int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dc = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            dir = (dir + 3) % 4; // 90도 회전
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length
            && !visited[nr][nc] && matrix[nr][nc] == 0) { // 주변 4칸 중 청소되지 않은 경우
                dfs(nr, nc, dir, matrix);
                return;
            }
        }
        // 후진 처리
        int backDir = (dir + 2) % 4;
        int br = row + dr[backDir];
        int bc = col + dc[backDir];

        if (br >= 0 && br < matrix.length && bc >= 0 && bc < matrix[0].length &&
                matrix[br][bc] == 0){
            dfs(br, bc, dir, matrix);
        }
    }
}
