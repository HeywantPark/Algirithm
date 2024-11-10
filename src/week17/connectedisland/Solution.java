
package week17.connectedisland;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] costs) {

        Map<Integer, List<Edge>> graph = new HashMap<>();

        for(int i = 0; i < n; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int w = cost[2];

            graph.get(u).add(new Edge(v,w));
            graph.get(v).add(new Edge(u,w));
        }
        Queue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];

        pq.offer(new Edge(0,0));

        int minCost = 0;
        int usedEdge = 0;

        while(!pq.isEmpty() && usedEdge < n){
            Edge cur = pq.poll();

            if(visited[cur.node]) continue;

            visited[cur.node] = true;
            minCost += cur.cost;
            usedEdge++;

            for(Edge next : graph.get(cur.node)){
                if(!visited[next.node]){
                    pq.offer(new Edge(next.node,next.cost));
                }
            }
        }
        return minCost;
    }
}
class Edge implements Comparable<Edge>{
    int node;
    int cost;

    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}
