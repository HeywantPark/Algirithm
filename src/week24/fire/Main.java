package week24.fire;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visited;
    static String[][] miro;
    static int[][] fireSpread;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        miro = new String[r][c];
        visited = new boolean[r][c];
        fireSpread = new int[r][c];

        Queue<int[]> jihun = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String[] parts = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                miro[i][j] = parts[j];
                fireSpread[i][j] = 987654321;
                if(miro[i][j].equals("J")) {
                    jihun.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
                if(miro[i][j].equals("F")) {
                    fire.offer(new int[]{i, j});
                    fireSpread[i][j] = 0;
                }
            }
        }
        spreadFire(fire,r,c); // 불의 이동 처리

        int result = moveJihun(jihun,r,c); // 지훈이 이동처리

        if(result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }
    static void spreadFire(Queue<int[]> fire, int r, int c) {

        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            int row = cur[0];
            int col = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nc >= 0 && nr < r && nc < c) {
                    if(!miro[nr][nc].equals("#") && fireSpread[nr][nc] > fireSpread[row][col] + 1) {
                        fireSpread[nr][nc] = fireSpread[row][col] + 1;
                        fire.offer(new int[]{nr, nc});
                    }
                }
            }
        }

    }
    static int moveJihun(Queue<int[]> jihun, int r, int c) {

        while (!jihun.isEmpty()) {
            int[] cur = jihun.poll();
            int row = cur[0];
            int col = cur[1];
            int time = cur[2];

            if(row == 0 || row == r - 1 || col == 0 || col == c - 1) {
                return time + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nc >= 0 && nr < r && nc < c) {
                    if(miro[nr][nc].equals(".") && !visited[nr][nc] && fireSpread[nr][nc] > time + 1) {
                        visited[nr][nc] = true;
                        jihun.offer(new int[]{nr, nc, time + 1});
                    }
                }
            }
        }
        return -1;
    }
}
