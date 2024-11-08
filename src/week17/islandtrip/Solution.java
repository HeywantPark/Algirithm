package week17.islandtrip;

import java.util.*;

public class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        List<Integer> result = new ArrayList<>(); // 최종 식량의 합 저장 리스트
        boolean[][] visited = new boolean[n][m];  // 방문 배열
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++){
                if(maps[r].charAt(c) != 'X' && !visited[r][c]) {
                    int foodCnt = 0; // 식량의 합
                    queue.offer(new int[]{r,c});
                    visited[r][c] = true;

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cr = cur[0];
                        int cc = cur[1];
                        foodCnt += maps[cr].charAt(cc) - '0';

                        for(int i = 0; i < 4; i++) {
                            int nr = cr + dr[i];
                            int nc = cc + dc[i];

                            if(nr >= 0 && nr < n && nc >= 0 && nc < m
                                    && maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                                queue.offer(new int[]{nr,nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    result.add(foodCnt);
                }
            }
        }
        if (result.isEmpty()) {
            return new int[]{-1};
        } else {
            Collections.sort(result);
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
