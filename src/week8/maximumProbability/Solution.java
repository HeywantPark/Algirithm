package week8.maximumProbability;

import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    double probability;

    public Edge(int node, double probability) {
        this.node = node;
        this.probability = probability;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(other.probability, this.probability);
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Edge(v, prob));
            graph.get(v).add(new Edge(u, prob));
        }

        double[] maxProb = new double[n];
        Arrays.fill(maxProb, 0.0);
        maxProb[start] = 1.0;

        Queue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 1.0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.node == end) {
                return cur.probability;
            }

            for (Edge next : graph.get(cur.node)) {
                double newProb = cur.probability * next.probability;
                if (newProb > maxProb[next.node]) {
                    maxProb[next.node] = newProb;
                    pq.add(new Edge(next.node, newProb));
                }
            }
        }

        return maxProb[end];
    }
}
