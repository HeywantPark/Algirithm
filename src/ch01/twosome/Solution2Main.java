package ch01.twosome;

import java.util.Arrays;

public class Solution2Main {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String answer = Arrays.toString(solution2.twoSum(new int[]{6, 3, 11, 15}, 9));
        System.out.println(answer);

    }
}
