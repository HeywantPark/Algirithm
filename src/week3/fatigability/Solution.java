package week3.fatigability;

public class Solution {
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        backTrack(k,dungeons,visited,0);
        return answer;
    }
    private void backTrack(int k,int[][] dungeons,boolean[] visited,int count){
        if(count > answer){
            answer = count;
        }
        for(int i = 0; i < dungeons.length; i++){
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                backTrack(k - dungeons[i][1],dungeons,visited,count+1);
                visited[i] = false;
            }
        }
    }
}
