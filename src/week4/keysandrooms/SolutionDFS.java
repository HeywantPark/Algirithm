package week4.keysandrooms;

import java.util.*;

public class SolutionDFS {
    static boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms,0);
        for(int i = 0; i < rooms.size(); i++) {
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms, int startVertex) {
        visited[startVertex] = true;
        for(int nestVertex : rooms.get(startVertex)) {
            if(!visited[nestVertex]) {
                dfs(rooms, nestVertex);
            }
        }
    }
    public static void main(String[] args) {
        SolutionDFS solution = new SolutionDFS();
        List<List<Integer>> rooms2 = Arrays.asList(
                Arrays.asList(1, 3),   // Room 0 has keys to rooms 1 and 3
                Arrays.asList(3, 0, 1),// Room 1 has keys to rooms 0, 1, and 3
                Arrays.asList(2),      // Room 2 has a key to room 2 (self-loop)
                new ArrayList<>()      // Room 3 has no keys
        );
        System.out.println(solution.canVisitAllRooms(rooms2));
    }
}
