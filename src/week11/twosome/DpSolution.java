package week11.twosome;

import java.util.*;

public class DpSolution {
    public int[] twoSum(int[] nums, int target) {
        //✅ 숫자와 숫자의 인덱스를 키, 밸류로 하는 빈 해시테이블을 만든다.
        Map<Integer, Integer> memo = new HashMap<>();
        //✅ 숫자들을 순회한다.
        for (int i = 0; i < nums.length; i++) {
            //✅ 목표값을 만들기 위한 나머지 숫자를 구한다.
            int needed = target - nums[i];
            //✅ 나머지 숫자가 해시테이블에 존재하면 그 수의 인덱스와 현재 인덱스를 반환한다.
            if (memo.containsKey(needed)) {
                return new int[] {memo.get(needed), i};
            }
            //✅ 아니라면 해시테이블에 숫자와 인덱스를 추가한다.
            memo.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
