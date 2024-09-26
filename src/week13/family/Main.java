package week13.family;

import java.util.*;

public class Main {
    public int solution(int k,int x, int y, int[][] family) {
        Map<Integer, List<Integer>> familyMap = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[k + 1];

        //전체 가족 수 k만큼 map 만들기
        for (int i = 1; i <= k; i++) {
            familyMap.put(i, new ArrayList<>());
        }
        //map 안에 가족관계 채우기
        for (int i = 0; i < family.length; i++) {
            familyMap.get(family[i][0]).add(family[i][1]);
            familyMap.get(family[i][1]).add(family[i][0]);
        }
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int dist = cur[1];

            if (curX == y) return dist;

            List<Integer> familyList = familyMap.get(curX);
            if (familyList != null) {
                for(int nextX : familyList) {
                    if(!visited[nextX]) {
                        queue.offer(new int[]{nextX, dist + 1});
                        visited[nextX] = true;
                    };
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        int n = scanner.nextInt();

        int[][] family = new int[n][2];

        for (int i = 0; i < n; i++) {
            family[i][0] = scanner.nextInt();
            family[i][1] = scanner.nextInt();
        }

        Main main = new Main();
        int result = main.solution(k, x, y, family);

        System.out.println(result); // 촌수 출력
        scanner.close();
    }
}
