package week16.nouturn;

import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] village = new char[r][c];

        // 마을 지도 입력
        for (int i = 0; i < r; i++) {
            String line = sc.next();
            village[i] = line.toCharArray();
        }
        // 막다른 길 인지 탐색
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (village[i][j] == '.') {
                    int pathCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < r && nc >= 0 && nc < c && village[nr][nc] == '.') {
                            pathCount++;
                        }
                    }
                    // 길이 1개 이하라면 막다른 길
                    if (pathCount <= 1) {
                        System.out.println(1);
                        return;
                    }
                }

            }
        }
        System.out.println(0);
    }
}
