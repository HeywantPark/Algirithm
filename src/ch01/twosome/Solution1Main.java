package ch01.twosome;

import java.util.Arrays;

public class Solution1Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String answer = Arrays.toString(solution1.twoSum(new int[]{2, 7, 11, 15}, 9));
        System.out.println(answer);
    }
}
