package week24.combackhome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int r,c,k;
    static int answer = 0;
    static String[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);

        map = new String[r][c];

        for (int i = 0; i < r; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = row[j];
            }
        }
        boolean[][] visited = new boolean[r][c];
        visited[r - 1][0] = true;
        dfs(r - 1,0,visited,1);
        System.out.println(answer);


    }
    private static void dfs(int startRow, int startCol, boolean[][] visited,int count) {

        if(startRow == 0 && startCol == c - 1) {
            if(count == k) {
                answer++;
                return;
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nr = startRow + dr[d];
            int nc = startCol + dc[d];

            if(nr >= 0 && nr < r && nc >= 0 && nc < c && !visited[nr][nc] && !map[nr][nc].equals("T")) {
                visited[nr][nc] = true;
                dfs(nr,nc,visited,count + 1);
                visited[nr][nc] = false;
            }
        }
    }
}
