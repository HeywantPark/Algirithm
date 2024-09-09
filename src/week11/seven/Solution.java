package week11.seven;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int totalSum = 0;

        // 9명의 난쟁이 키 입력 받기
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            totalSum += heights[i];
        }
        int fake1 = -1, fake2 = -1;

        // 이중 루프를 사용하여 두 명의 난쟁이 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (totalSum - (heights[i] + heights[j]) == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if (fake1 != -1 && fake2 != -1) {
                break;
            }
        }

        // 제외할 두 난쟁이를 제외한 나머지 난쟁이들의 키를 오름차순으로 출력
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != fake1 && i != fake2) {
                result.add(heights[i]);
            }
        }

        Collections.sort(result); // 오름차순 정렬
        for (int height : result) {
            System.out.println(height);
        }
    }
}
