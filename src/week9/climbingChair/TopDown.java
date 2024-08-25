package week9.climbingChair;

import java.util.Arrays;

public class TopDown {
    public int solution(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);

        return dp(n, memo);
    }

    public int dp(int n, int[] memo) {
        memo[1] = 1;
        memo[2] = 2;

        if (memo[n] == -1) {
            memo[n] = dp(n-1, memo) + dp(n-2, memo);
        }
        return memo[n];
    }
}
