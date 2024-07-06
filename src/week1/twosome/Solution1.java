package week1.twosome;

import java.util.Arrays;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // 완전 탐색
        // 2중 for 문으로 두 수를 선택한다.
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String answer = Arrays.toString(solution2.twoSum(new int[]{6, 3, 11, 15}, 9));
        System.out.println(answer);
    }
}
