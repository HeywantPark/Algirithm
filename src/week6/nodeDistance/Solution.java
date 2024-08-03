package week6.nodeDistance;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 1; i <= n; i++){
            graph.put(i,new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(new int[]{1,0});
        visited[1] = true;
        int maxDist = 0;

        while(!queue.isEmpty()){
            int[] curVer = queue.poll();

            if(maxDist < curVer[1]){
                maxDist = curVer[1];
                answer = 1;
            } else if (maxDist == curVer[1]){
                answer++;
            }

            for(int nextVer : graph.get(curVer[0])){
                if(!visited[nextVer]){
                    queue.offer(new int[]{nextVer,curVer[1] + 1});
                    visited[nextVer] = true;
                }
            }
        }
        return answer;
    }
}
