package week27.vivaragi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] sky = new int[n][n];
        int[][] moves = new int[m][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sky[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                moves[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dr = {0,-1,-1,-1,0,1,1,1};
        int[] dc = {-1,-1,0,1,1,1,0,-1};
        List<int[]> cloud = new ArrayList<>();

        cloud.add(new int[]{n-1,0});
        cloud.add(new int[]{n-1,1});
        cloud.add(new int[]{n-2,0});
        cloud.add(new int[]{n-2,1});

        for (int i = 0; i < m; i++) {

            int d = moves[i][0];
            int s = moves[i][1];

            // 구름 이동
            List<int[]> moved = new ArrayList<>();
            for (int[] c : cloud){
                int nr = (c[0] + dr[d - 1] * s + n * 1000) % n;
                int nc = (c[1] + dc[d - 1] * s + n * 1000) % n;
                moved.add(new int[]{nr,nc});
            }

            // 비 내리기 + 구름 위치 기록
            boolean[][] visited = new boolean[n][n];
            for (int[] c : moved){
                int cr = c[0];
                int cc = c[1];
                sky[cr][cc]++;
                visited[cr][cc] = true;
            }
            // 대각선 물복사 확인
            int[] diagR = {-1, -1, 1, 1}; // 대각선 방향
            int[] diagC = {-1, 1, -1, 1};
            for (int[] c : moved){
                int cr = c[0];
                int cc = c[1];
                int count = 0;
                for (int j = 0; j < 4; j++){
                    int nr = cr + diagR[j];
                    int nc = cc + diagC[j];
                    if (nr >= 0 && nc >= 0 && nr < n && nc < n){
                        if (sky[nr][nc] > 0) count++;
                    }
                }
                sky[cr][cc] += count;
            }
            // 새 구름 생성
            cloud.clear();
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    if (visited[r][c]) continue;
                    if (sky[r][c] >= 2) {
                        cloud.add(new int[]{r,c});
                        sky[r][c] -= 2;
                    }
                }
            }
        }
        int total = 0;
        for (int[] row : sky){
            for (int val : row){
                total += val;
            }
        }
        System.out.println(total);
    }
}
