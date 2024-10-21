package week16.minimumcost;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //노드의 개수
        int m = sc.nextInt(); //간선의 개수

        int[][] city = new int[m][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                city[i][j] = sc.nextInt();
            }
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        // 도시맵 초기화
        Map<Integer, List<Edge>> cityMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            cityMap.put(i, new ArrayList<>());
        }
        for (int[] c : city) {
            int u = c[0];
            int v = c[1];
            int w = c[2];

            cityMap.get(u).add(new Edge(v,w));
        }
        int[] dist = new int[n + 1]; // 노드별 시간 비용
        Arrays.fill(dist, Integer.MAX_VALUE);


        Queue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(start,0)); // 첫번째 노드 방문
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(dist[cur.node] < cur.cost) continue; //이전 경로의 비용이 더 적으면 건너뜀

            for (Edge next : cityMap.get(cur.node)) {
                int nextCost = dist[cur.node] + next.cost; // 다음 노드의 비용 계산
                if(dist[next.node] > nextCost) { // 만약 이전에 방문한 비용보다 이번 경로의 비용이 더 적으면
                    pq.offer(new Edge(next.node,nextCost));
                    dist[next.node] = nextCost;
                }
            }

        }
        System.out.println(dist[end]);
    }
    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
