package week27.babyshark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] sea;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sea = new int[n][n];

        int[] sharkNode = new int[2];
        int size = 2;
        int eaten = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if (sea[i][j] == 9) {
                    sharkNode[0] = i;
                    sharkNode[1] = j;
                    sea[i][j] = 0;
                }
            }
        }
        while (true) {
            Node target = bfs(sharkNode[0], sharkNode[1], size);

            if (target == null) break;

            time += target.dist;
            eaten++;
            if (eaten == size) {
                size++;
                eaten = 0;
            }
            sea[target.x][target.y] = 0;
            sharkNode[0] = target.x;
            sharkNode[1] = target.y;

        }
        System.out.println(time);
    }
    private static Node bfs(int x, int y, int size) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>(); // 이동할 좌표저장
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 먹은 물고기 좌표 저장

        visited[x][y] = true;
        q.offer(new int[]{x, y, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (visited[nr][nc] || sea[nr][nc] > size) continue;

                visited[nr][nc] = true;
                if (sea[nr][nc] != 0 && sea[nr][nc] < size) {
                    pq.offer(new Node(nr, nc, dist + 1));
                }
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }
        return pq.isEmpty() ? null : pq.poll();
    }

}
class Node implements Comparable<Node>{
    int x;
    int y;
    int dist;
    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o) {
        if (this.dist != o.dist) return this.dist - o.dist; // dist 오름차순
        if (this.x != o.x) return this.x - o.x; // x 오름차순
        return this.y - o.y; // y 오름차순
    }
}
