package week1.twosome;

import java.util.Arrays;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        //숫자와 숫자의 원래 인덱스를 저장하는 2차원 배열을 생성한다.
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        // 배열의 숫자를 오름차순으로 정렬한다.
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        // 첫번 째 인덱스와 마지막 인덱스를 각각 가리키는 투포인터를 생성한다.
        int l = 0; int r = nums.length - 1;
        //왼쪽 포인터가 오른쪽 포인터보다 작을동안 반복한다.
        while (l < r) {
            if (arr[l][0] + arr[r][0] > target)
                r -= 1;
            else if (arr[l][0] + arr[r][0] < target)
                l += 1;
            else
                return new int[]{arr[l][1], arr[r][1]};
        }
        return new int[]{ -1, -1 };
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String answer = Arrays.toString(solution2.twoSum(new int[]{6, 3, 11, 15}, 9));
        System.out.println(answer);
    }
}
