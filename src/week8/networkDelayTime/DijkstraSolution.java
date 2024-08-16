package week8.networkDelayTime;

import java.util.*;

class Edge implements Comparable<Edge> {
    int node, cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 초기세팅
        // 인접리스트 만들기
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++){
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Edge(v, w));
        }
        // costs 배열 만들기
        int INF = Integer.MAX_VALUE;
        int[] costs = new int[n+1];
        Arrays.fill(costs, INF);

        // 다익스트라 알고리즘 실행
        // 시작점 예약하기
        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(k, 0));
        costs[k] = 0;

        while (!pq.isEmpty()) {
            // 방문
            Edge cur = pq.remove();
            if (costs[cur.node] < cur.cost) continue;

            // 예약
            for (Edge next : graph.get(cur.node)) {
                int nextCost = costs[cur.node] + next.cost;
                if (nextCost < costs[next.node]) {
                    pq.add(new Edge(next.node, nextCost));
                    costs[next.node] = nextCost;
                }
            }
        }

        //costs 배열을 순회하여 max값 찾기
        int maxTime = 0;
        for (int i = 1; i <= n; i++){
            if (costs[i] == INF) return -1;
            maxTime = Math.max(maxTime, costs[i]);
        }

        return maxTime;
    }
}
