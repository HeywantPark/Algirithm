package week10.oildrilling;

import java.util.*;

public class Solution2 {
    int m, n;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(int[][] land) {
        m = land.length;
        n = land[0].length;
        int answer = 0;
        for (int col = 0; col<n; col++){
            answer = Math.max(answer, setPipe(land, col));
        }
        return answer;
    }
    public int setPipe(int[][] land, int col){
        boolean[][] visited = new boolean[m][n];
        int ret = 0;
        for (int row = 0; row<m; row++){
            ret+=bfs(land, visited, row, col);
        }
        return ret;
    }
    public int bfs(int[][] land, boolean[][] visited, int row, int col){
        int ret = 0;
        if (land[row][col] == 1 && !visited[row][col]){
            Deque<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(row, col));
            visited[row][col] = true;
            ret++;
            while (!queue.isEmpty()){
                Pair cur = queue.remove();
                for (int[] d : dir){
                    int nextR = cur.row+d[0], nextC = cur.col+d[1];
                    if (0 <= nextR && nextR < m && 0 <= nextC && nextC < n && land[nextR][nextC] == 1 && !visited[nextR][nextC]){
                        queue.add(new Pair(nextR, nextC));
                        visited[nextR][nextC] = true;
                        ret++;
                    }
                }
            }
        }
        return ret;
    }
    class Pair{
        int row, col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
