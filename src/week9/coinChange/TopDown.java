package week9.coinChange;

import java.util.Arrays;

public class TopDown {
    public int solution(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo,Integer.MAX_VALUE);
        int answer = dp(coins, amount, memo);
        return answer == Integer.MAX_VALUE? -1: answer;

    }
    int dp(int[] coins, int amount,int[] memo){
        int result = Integer.MAX_VALUE;

        if(amount == 0) return 0;

        for(int c : coins){
            if(amount - c >= 0){
                if(memo[amount - c] == Integer.MAX_VALUE){
                    memo[amount - c] = dp(coins, amount - c, memo);
                }
                result = Math.min(result,memo[amount - c]);
            }
        }
        return result == Integer.MAX_VALUE ? result : result + 1;
    }
}
