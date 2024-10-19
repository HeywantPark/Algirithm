package week15.findparentsnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    static boolean[] visited;
    static List<Integer>[] adjList;
    static int[] parent;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드의 개수
        visited = new boolean[n + 1]; // 방문 여부
        parent = new int[n + 1]; // 부모 노드 저장 배열
        adjList = new ArrayList[n + 1];

        // 인접 리스트 초기화
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        // 인접 리스트에 연결되 노드 추가하기
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }
        dfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }
    public static void dfs(int node) {
        // 방문 표시
        visited[node] = true;

        // 다음 노드 예약
        for (int next : adjList[node]) {
            if (!visited[next]) {
                parent[next] = node; // 부모 노드 저장
                dfs(next);
            }
        }
    }
}











