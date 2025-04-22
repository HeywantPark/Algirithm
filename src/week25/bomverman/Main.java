package week25.bomverman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().split(" ");
        int r = Integer.parseInt(words[0]);
        int c = Integer.parseInt(words[1]);
        int n = Integer.parseInt(words[2]);

        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line[j];
            }
        }
        int[][] step = new int[r][c];
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 1, 0, -1};
        while(n > 0){

            // 초기값 세팅
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (matrix[i][j].equals("0")) {
                        step[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int cur = step[i][j];
                    if (cur % 3 == 0) {
                        matrix[i][j] = ".";
                        for (int k = 0; k < 4; k++) {
                            int nr = cur + dr[k];
                            int nc = cur + dc[k];
                            matrix[nr][nc] = ".";
                        }
                        step[i][j] = 0;
                    } else {
                        if (matrix[i][j].equals(".")) matrix[i][j] = "0";
                    }
                }
            }
        }
    }
}
