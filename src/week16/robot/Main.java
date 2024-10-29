package week16.robot;

import java.util.Scanner;

public class Main {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        boolean[][] visited = new boolean[r][c]; // 방문표시 배열

        int k = scanner.nextInt();  // 장애물 개수

        for (int i = 0; i < k; i++) {
            int br = scanner.nextInt();
            int bc = scanner.nextInt();
            visited[br][bc] = true; // 장애물 자리에 true 표시
        }

        int sr = scanner.nextInt();
        int sc = scanner.nextInt();

        int[] direc = new int[4];
        for (int i = 0; i < 4; i++) {
            direc[i] = scanner.nextInt() -1; // 1,2,3,4 를 0,1,2,3 으로 변경
        }

        visited[sr][sc] = true; // 시작위치 방문처리

        int dir = 0;
        while(true) {
            boolean moved = false;
            for (int i = 0; i < 4; i++) { // 현재 방향부터 4방향 탐색
                int nowDir = (dir + i) % 4;
                int nr = sr + dr[direc[nowDir]];
                int nc = sc + dc[direc[nowDir]];

                if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
                    if(!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        dir = nowDir;
                        sr = nr;
                        sc = nc;
                        moved = true;
                        break;
                    }
                }
            }
            if(!moved) break;
        }
        System.out.println(sr + " " + sc);

    }

}










