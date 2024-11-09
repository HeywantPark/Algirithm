package week17.thefurthestnode;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] edge) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            graph.put(i,new ArrayList<>());
        }
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        queue.offer(new int[]{1,0});
        visited[1] = true;
        int maxDist = -1;
        int count = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[1] > maxDist) {
                maxDist = cur[1];
                count = 1;
            } else if (cur[1] == maxDist){
                count++;
            }

            for(int next : graph.get(cur[0])){
                if(!visited[next]){
                    queue.offer(new int[]{next,cur[1] + 1});
                    visited[next] = true;
                }
            }
        }
        return count;
    }
}
