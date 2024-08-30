package week5.distancing;

import java.util.*;

public class Solution {
    boolean[][] visited;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i < places.length; i++){
            if(checkPlace(places[i])) answer[i] = 1;
        }
        return answer;
    }
    boolean checkPlace(String[] place){
        visited = new boolean[5][5];

        for(int r = 0; r < 5; r++){
            for(int c =0; c < 5; c++){
                if(place[r].charAt(c) == 'P'){
                    if(!checkVirus(r,c,place)) return false;
                }
            }
        }
        return true;

    }
    boolean checkVirus(int r, int c,String[] places){
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{r,c,0});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int ndist = cur[2] + 1;

                if(isRange(nr,nc) && !visited[nr][nc] && places[nr].charAt(nc) != 'X') {
                    if(ndist > 2) continue;

                    if(places[nr].charAt(nc) == 'P') return false;
                    queue.offer(new int[]{nr,nc,ndist});
                    visited[nr][nc] = true;
                }
            }
        }
        return true;
    }
    boolean isRange(int r, int c){
        return (r >= 0) && (r < 5) && (c >=0) && (c < 5);
    }
}
