package week20.lottoGrade;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int[] solution(int[] lottos, int[] win_nums) {
        // 1. 당첨 번호를 Set으로 저장
        Set<Integer> winSet = new HashSet<>();
        for (int num : win_nums) {
            winSet.add(num);
        }

        // 2. 0의 개수와 당첨 번호 일치 개수 계산
        int zeroCnt = 0;
        int lottoCnt = 0;

        for (int l : lottos) {
            if (l == 0) {
                zeroCnt++;
            } else if (winSet.contains(l)) {
                lottoCnt++;
            }
        }

        // 3. 최대, 최소 일치 개수 계산
        int maxNum = lottoCnt + zeroCnt;
        int minNum = lottoCnt;

        // 4. 등수를 배열로 처리 (6개 맞으면 1등, 5개 맞으면 2등, ...)
        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        // 5. 결과 반환
        return new int[]{rank[maxNum], rank[minNum]};
    }
}
