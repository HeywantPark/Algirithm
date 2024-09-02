package week16.tree;

import java.util.*;

public class Main {

    static boolean[] visited;
    static boolean isTree;
    static List<Integer>[] adj;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int caseNum = 1;

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break; // n,m 이 0 이 될때까지 while 문 반복

            // 인접리스트 생성
            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            int count = 0;
            visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    isTree = true;
                    dfs(i,0);
                    if (isTree) count++; // dfs 실행 후 트리의 조건을 만족하면 count+1;
                }
            }
            if (count == 0) System.out.println("Case " + caseNum + ": No trees.");
            if (count == 1) System.out.println("Case " + caseNum + ": There is one tree.");
            if (count > 1) System.out.println("Case " + caseNum + ": A forest of " + count + " trees.");
            caseNum++;
        }
    }
    private static void dfs(int cur, int parent) {
        visited[cur] = true;

        for (int next : adj[cur]) {
            if (!visited[next]) {
                dfs(next,cur);
            } else if (next != parent) {
                // 다음 노드가 이미 방문되었는데, 그 노드가 부모 정점이 아니라면 사이클이 존재
                isTree = false;
            }
        }
    }
}
