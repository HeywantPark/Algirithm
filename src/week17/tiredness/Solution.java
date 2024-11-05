package week17.tiredness;

public class Solution {
    int maxCount = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        permutation(k,dungeons,0);
        return maxCount;
    }
    public void permutation(int cur, int[][] dungeons,int count){
        if (count > maxCount) {
            maxCount = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (cur >= dungeons[i][0] && !visited[i]){
                int next = cur - dungeons[i][1];
                visited[i] = true;
                permutation(next,dungeons,count+1);
                visited[i] = false;
            }
        }
    }
}
