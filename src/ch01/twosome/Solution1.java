package ch01.twosome;

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
}
