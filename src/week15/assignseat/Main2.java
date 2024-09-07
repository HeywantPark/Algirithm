package week15.assignseat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());


        if (k > c * r) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[r][c];
        int x = r - 1, y = 0, dir = 0;
        map[x][y] = 1;
        int num = 1;


        if (k == 1) {
            System.out.println(1 + " " + 1);
            return;
        }

        while (num < k) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] == 0) {
                x = nx;
                y = ny;
                num++;
                map[x][y] = num;

                if (num == k) {
                    System.out.println((y + 1) + " " + (r - x));
                    return;
                }
            } else {
                dir = (dir + 1) % 4;
            }
        }
    }
}