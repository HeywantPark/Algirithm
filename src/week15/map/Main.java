package week15.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        String[][] islands = new String[r][c];

        sc.nextLine(); // 다음 줄로 이동

        for (int i = 0; i < r; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < c; j++) {
                islands[i][j] = String.valueOf(line.charAt(j));
            }
        }
        List<int[]> update = new ArrayList<>();

        // 지도를 돌면서 바다로 잠길 땅 찾기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (islands[i][j].equals("X")) {
                    int count = bfs(i,j,islands,r,c);
                    if (count >= 3) {
                        update.add(new int[]{i, j});
                    }
                }
            }
        }
        // 잠긴 바다 지도 업데이트 해주기
        for (int[] u : update) {
            islands[u[0]][u[1]] = ".";
        }
        // 지도의 최소, 최댓값 구하기
        int maxX = 0, maxY = 0, minX = r, minY = c;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (islands[i][j].equals("X")) {
                    maxX = Math.max(maxX,i);
                    maxY = Math.max(maxY,j);
                    minX = Math.min(minX,i);
                    minY = Math.min(minY,j);
                }
            }
        }
        // 업데이트 된 지도 출력하기
        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                System.out.print(islands[i][j]);
            }
            System.out.println();
        }
    }
    static int bfs(int row, int col, String[][] islands,int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nc < 0 || nr >= r || nc >= c || islands[nr][nc].equals(".")) {
                count += 1;
            }
        }
        return count;
    }
}
