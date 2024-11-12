package week18.delivery;

import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {

        // 그래프를 저장할 HashMap을 선언합니다.
        Map<Integer, List<Edge>> graph = new HashMap<>();

        // 1부터 N까지 각 노드에 빈 리스트를 초기화합니다.
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 도로 정보를 기반으로 양방향 간선을 그래프에 추가합니다.
        for (int[] r : road) {
            int u = r[0]; // 출발 노드
            int v = r[1]; // 도착 노드
            int w = r[2]; // 두 노드 간의 거리

            // 양방향이므로 두 방향 모두 추가합니다.
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }

        // 우선순위 큐를 이용하여 다익스트라 알고리즘을 수행합니다.
        Queue<Edge> queue = new PriorityQueue<>();
        int[] times = new int[N + 1]; // 각 노드에 도달하는 데 걸리는 최소 시간을 저장하는 배열입니다.

        // 모든 노드의 시간을 무한대로 초기화하여 방문하지 않은 상태로 설정합니다.
        Arrays.fill(times, Integer.MAX_VALUE);

        // 시작점(1번 노드)을 큐에 추가하고, 초기 시간(거리)은 0으로 설정합니다.
        queue.offer(new Edge(1, 0));
        times[1] = 0;

        // 다익스트라 알고리즘을 실행합니다.
        while (!queue.isEmpty()) {
            Edge cur = queue.poll(); // 큐에서 가장 시간이 적은 노드를 꺼냅니다.

            // 이미 최단 시간이 계산된 경우 생략합니다.
            if (cur.time > times[cur.node]) continue;

            // 현재 노드와 연결된 다른 노드들에 대해 최단 시간을 갱신합니다.
            for (Edge next : graph.get(cur.node)) {
                int nextTime = next.time + times[cur.node]; // 현재 노드를 거쳐 다음 노드로 가는 시간 계산
                // 새로운 시간이 기존 최단 시간보다 작다면 갱신하고 큐에 추가합니다.
                if (nextTime < times[next.node]) {
                    times[next.node] = nextTime;
                    queue.offer(new Edge(next.node, next.time));
                }
            }
        }

        // 제한 시간 K 이내에 도달 가능한 노드 수를 계산합니다.
        int answer = 0;
        for (int t : times) {
            if (t <= K) answer++;
        }
        return answer;
    }
}

// Edge 클래스: 노드와 그 노드까지의 시간을 저장하며, 우선순위 큐에서 시간 기준으로 정렬됩니다.
class Edge implements Comparable<Edge> {
    int node; // 현재 노드
    int time; // 시작 노드에서 현재 노드까지 걸리는 시간

    public Edge(int node, int time) {
        this.node = node;
        this.time = time;
    }

    // 시간 기준으로 비교하여 우선순위 큐에서 최소 시간이 먼저 나오도록 설정합니다.
    public int compareTo(Edge other) {
        return Integer.compare(this.time, other.time);
    }
}

