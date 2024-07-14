package week2.stock_prices;

import java.util.*;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int curr = 0; curr < prices.length; curr++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[curr]) {
                int prev = stack.pop();
                answer[prev] = curr - prev;
            }
            stack.push(curr);
        }
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            answer[prev] = prices.length - 1 - prev;
        }
        return answer;
    }
}
