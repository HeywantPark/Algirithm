package week6.divisionElectric;

import java.util.*;

public class Solution {
    int answer;
    boolean[] visited;
    Map<Integer,List<Integer>> graph = new HashMap<>();

    public int solution(int n, int[][] wires) {
        answer = n;
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        dfs(1,n);
        return answer;
    }
    int dfs(int curVer, int n){
        int count = 1;
        visited[curVer] = true;
        for(int nextVer : graph.get(curVer)){
            if(!visited[nextVer]){
                count += dfs(nextVer,n);
            }
        }
        answer = Math.min(answer,Math.abs(n - count * 2));
        return count;
    }
}
