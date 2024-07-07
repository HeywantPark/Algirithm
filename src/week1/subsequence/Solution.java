package week1.subsequence;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1000000};
        int total = 0;
        int start = 0;
        for (int end = 0; end < sequence.length ; end++ ) {
            total += sequence[end];
            while(total > k) {
                total -= sequence[start];
                start++;
            }
            if (total == k){
                if ((end - start) < (answer[1] - answer[0])) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(new int[]{1, 2, 3, 4, 5, 6}, 9);
        System.out.println(Arrays.toString(answer));
    }
}
