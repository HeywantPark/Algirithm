package week13.marrige;

import java.util.*;

public class Main {
    public int solution(int n, int[][] friend) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        // 친구 관계 맵 생성
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < friend.length; i++) {
            map.get(friend[i][0]).add(friend[i][1]);
            map.get(friend[i][1]).add(friend[i][0]);
        }

        // 1번부터 BFS 시작
        queue.offer(new int[]{1, 0});
        visited[1] = true;
        int count = 0;

        // BFS 실행
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curf = cur[0];  // 현재 친구 번호
            int dist = cur[1];  // 상근이로부터의 거리

            // 거리가 1 또는 2일 때 초대할 사람 수에 포함
            if (dist == 1 || dist == 2) {
                count++;
            }

            // 거리 2 이상은 초대 대상이 아니므로 더 깊이 탐색하지 않음
            if (dist >= 2) continue;

            // 현재 친구의 친구들을 큐에 추가
            for (int i = 0; i < map.get(curf).size(); i++) {
                int nextf = map.get(curf).get(i);
                if (!visited[nextf]) {
                    visited[nextf] = true;
                    queue.offer(new int[]{nextf, dist + 1});
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 동기의 수
        int m = scanner.nextInt();  // 친구 관계의 수

        int[][] friend = new int[m][2];  // 친구 관계 입력
        for (int i = 0; i < m; i++) {
            friend[i][0] = scanner.nextInt();
            friend[i][1] = scanner.nextInt();
        }


        System.out.println(new Main().solution(n, friend));
    }
}
