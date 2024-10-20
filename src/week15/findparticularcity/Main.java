package week15.findparticularcity;

import java.util.*;
import java.util.Scanner;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static Queue<Integer> q;
    static int[] dist;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 수
        int m = sc.nextInt(); // 간선의 수
        int k = sc.nextInt(); // 찾아야할 최단거리
        int x = sc.nextInt(); // 시작 노드

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            adjList[v].add(u);
        }
        q = new ArrayDeque<>();

        bfs(x);

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
    public static void bfs(int start) {
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                }
            }
        }
    }
}
