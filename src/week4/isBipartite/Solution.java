package week4.isBipartite;

import java.util.Arrays;

public class Solution {
    public boolean isBipartite(int[][] graph) {
        final int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);  // 모든 노드를 -1로 초기화 (아직 색이 지정되지 않은 상태)
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(graph, color, 0, i) == false)
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int c, int i) {
        color[i] = c;  // 현재 노드 i를 색 c로 색칠
        for (int next : graph[i]) {
            if (color[next] == -1) {  // 만약 다음 노드가 아직 색칠되지 않았다면
                if (dfs(graph, color, 1 - c, next) == false)
                    return false;
            } else if (color[next] == color[i]) {  // 만약 다음 노드가 현재 노드와 같은 색이라면
                return false;
            }
        }
        return true;
    }

}
