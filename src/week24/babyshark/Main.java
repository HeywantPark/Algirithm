package week24.babyshark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n , m;
    static int[][] cage;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        cage = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                cage[i][j] = Integer.parseInt(row[j]);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cage[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[] dr = {1,1,-1,-1,0,0,1,-1};
        int[] dc = {0,-1,0,-1,-1,1,1,1};

        int maxCount = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int k = 0; k < 8; k++) {
                int nr = cr + dr[k];
                int nc = cc + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                // 이미 방문한 경우 패스
                if (visited[nr][nc]) continue;

                // 다른 상어를 만나면 종료
                if (cage[nr][nc] == 1) continue;

                // 거리 갱신 및 큐에 추가
                cage[nr][nc] = cage[cr][cc] + 1;
                maxCount = Math.max(maxCount, cage[nr][nc] - 1); // 안전거리 계산

                System.out.println("Updated cage after (" + nr + ", " + nc + ") = " + cage[nr][nc]);
                printCage();

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
        System.out.println(maxCount);
    }
    static void printCage() {
        System.out.println("========== Cage State ==========");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(cage[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }
}
