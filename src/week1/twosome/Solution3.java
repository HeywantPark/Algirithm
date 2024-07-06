package week1.twosome;

import java.util.Arrays;
import java.util.HashMap;

public class Solution3 {
    public int[] twoSum(int[] nums, int target){
        // 숫자와 숫자의 인덱스를 키, 벨류로 하는 빈 해시테이블을 만든다.
        HashMap<Integer, Integer> map = new HashMap<>();
        //숫자들을 순회하며 나머지 목표 값을 만든다.
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //나머지 숫자가 해시테이블에 존재하면 그 수의 인덱스와 현재 인덱스를 반환한다.
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // 아니라면 해시테이블에 숫자와 인덱스를 추가한다.
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String answer = Arrays.toString(solution3.twoSum(new int[]{6, 3, 11, 15}, 9));
        System.out.println(answer);
    }
}
