package week4.keysandrooms;

import java.util.*;

public class SolutionBFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        bfs(rooms,visited,0);
        for(int i = 0; i < rooms.size(); i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
    public void bfs(List<List<Integer>> rooms, boolean[] visited, int startVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startVertex);
        visited[startVertex] = true;

        while(!queue.isEmpty()) {
            int curVertex = queue.poll();
            for(int nextVertex : rooms.get(curVertex)) {
                if(!visited[nextVertex]) {
                    queue.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        SolutionBFS solution = new SolutionBFS();
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1, 3),   // Room 0 has keys to rooms 1 and 3
                Arrays.asList(3, 0, 1),// Room 1 has keys to rooms 0, 1, and 3
                Arrays.asList(2),      // Room 2 has a key to room 2 (self-loop)
                new ArrayList<>()      // Room 3 has no keys
        );
        System.out.println(solution.canVisitAllRooms(rooms)); // Expected output: true
    }
}
