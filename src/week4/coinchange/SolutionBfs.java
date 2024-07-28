package week4.coinchange;

import java.util.*;

public class SolutionBfs {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        Queue<Entry> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];

        queue.offer(new Entry(amount,0));

        while(!queue.isEmpty()){
            Entry currVer = queue.poll();

            for(int i = 0; i < coins.length; i++){
                int nextVer = currVer.amount - coins[i];
                if(nextVer == 0) {
                    return currVer.count +1;
                }
                else if(nextVer > 0 && !visited[nextVer]) {
                    queue.offer(new Entry(nextVer,currVer.count+1));
                    visited[nextVer] = true;
                }
            }
        }
        return -1;
    }

    static class Entry{
        int amount;
        int count;

        public Entry(int amount, int count){
            this.amount = amount;
            this.count = count;
        }
    }
}
