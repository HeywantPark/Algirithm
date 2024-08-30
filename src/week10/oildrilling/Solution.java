package week10.oildrilling;

import java.util.*;

public class Solution {
    int n;
    int m;
    boolean[][] visited;

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        Map<Integer,Integer> totalOils = new HashMap<>();

        int answer = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(!visited[r][c] && land[r][c] == 1){
                    Set<Integer> cols = new HashSet<>();
                    int oils = bfs(r,c,land,cols);

                    for(int col : cols){
                        totalOils.put(col,totalOils.getOrDefault(col,0) + oils);
                    }
                }
            }
        }
        for(int v : totalOils.values()){
            answer = Math.max(answer,v);
        }
        return answer;
    }
    int bfs(int r, int c,int[][] land,Set<Integer> cols){
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;

        int oils = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            oils++;
            cols.add(cur[1]);

            for(int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    if(!visited[nr][nc] && land[nr][nc] == 1){
                        queue.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return oils;
    }
}
