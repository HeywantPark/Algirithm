package week24.party;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<Edge>> edges;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        edges = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            int u = Integer.parseInt(line[2]);
            edges.get(s).add(new Edge(e, u));
        }

        // x에서 각 마을로 가는 최단 거리
        int[] distFromX = new int[n + 1]; // x에서 각 마을까지의 최단거리 저장
        Arrays.fill(distFromX, Integer.MAX_VALUE);
        dijkstra(x, distFromX);

        int maxTime = 0;

        // 각 마을에서 x로 가는 최단 거리
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int[] distToX = new int[n + 1]; // i에서 각 마을까지의 최단거리 저장 (x 까지의 거리는 x행에 저장)
            Arrays.fill(distToX, Integer.MAX_VALUE);
            dijkstra(i, distToX);
            maxTime = Math.max(maxTime, distToX[x] + distFromX[i]);
        }
        System.out.println(maxTime);

    }

    // 다익스트라 알고리즘
    private static void dijkstra(int start, int[] dist) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.time > dist[cur.node]) continue;

            for(Edge next : edges.get(cur.node)) {
                int nextDist = dist[cur.node] + next.time;

                if(dist[next.node] > nextDist) {
                    pq.offer(new Edge(next.node, nextDist));
                    dist[next.node] = nextDist;
                }
            }
        }
    }
}
class Edge implements Comparable<Edge> {
    int node;
    int time;

    public Edge(int node, int time) {
        this.node = node;
        this.time = time;
    }
    @Override
    public int compareTo (Edge other){
        return Integer.compare(this.time, other.time); // 시간이 작은 순서대로
    }
}
