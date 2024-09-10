package week11.seven;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        int sum = 0;

        // 9명의 난쟁이 키 입력받기
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum+=heights[i];
        }

        sum-=100;

        // 합이 sum이 되는 두 수 찾기
        HashSet<Integer> set = new HashSet<>();
        int first = 0, second = 0;
        for (int i = 0; i < 9; i++) {
            int target = sum - heights[i];
            if (set.contains(target)) {
                // 합이 sum이 되는 두 수를 찾은 경우
                first = heights[i];
                second = target;
                break;
            }
            set.add(heights[i]);
        }

        // 두 수를 제외한 나머지 7개의 숫자를 새로운 배열로 만듦
        int[] result = new int[7];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (heights[i] != first && heights[i] != second) {
                result[idx++] = heights[i];
            }
        }

        // 나머지 7개의 숫자를 오름차순으로 정렬
        Arrays.sort(result);

        // 결과 출력
        for (int height : result) {
            System.out.println(height);
        }
    }
}
}
