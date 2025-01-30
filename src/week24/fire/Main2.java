package week24.fire;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int R, C;
    private static char[][] graph = {};
    private static Queue<int[]> jQueue = new LinkedList<>();
    private static Queue<int[]> fQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.next();

            for (int j = 0; j < C; j++) {
                graph[i][j] = line.charAt(j);

                if (graph[i][j] == 'J') {
                    jQueue.offer(new int[]{i, j});
                }

                if (graph[i][j] == 'F') {
                    fQueue.offer(new int[]{i, j});
                }
            }
        }
        bfs();
    }

    public static void bfs() {
        int result = 0;

        while (true) {
            result++;

            int fSize = fQueue.size();

            while (fSize > 0) {
                fSize--;

                int[] q = fQueue.poll();
                int x = q[0];
                int y = q[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < R && 0 <= ny && ny < C && (graph[nx][ny] == 'J' || graph[nx][ny] == '.')) {
                        graph[nx][ny] = 'F';
                        fQueue.offer(new int[]{nx, ny});
                    }
                }
            }

            int jSize = jQueue.size();

            while (jSize > 0) {
                jSize--;

                int[] q = jQueue.poll();
                int x = q[0];
                int y = q[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        System.out.println(result);
                        return;
                    }

                    if (graph[nx][ny] == '.') {
                        graph[nx][ny] = 'J';
                        jQueue.offer(new int[]{nx, ny});
                    }
                }
            }

            if (jQueue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
