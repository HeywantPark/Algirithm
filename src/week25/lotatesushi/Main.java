package week25.lotatesushi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 접시의 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시의 수
        int c = sc.nextInt(); // 쿠폰 번호

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = sc.nextInt();
        }
        // k개의 접시만큼 초밥을 선택
        int[] count = new int[d + 1];
        int unique = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) {
                unique++;
            }
            count[sushi[i]]++;
        }
        int max = unique;
        if (count[c] == 0) max++;

        for (int i = 0; i < n - 1; i++) {
            // 앞 초밥 제거
            int remove = sushi[i];
            count[remove]--;
            if (count[remove] == 0) unique--;

            // 뒤 초밥 추가
            int add = sushi[(i + k) % n];
            count[add]++;
            if (count[add] == 1) unique++;

            // 쿠폰 번호 확인
            int temp = unique;
            if (count[c] == 0) temp++;
            max = Math.max(max, temp);
        }
        System.out.println(max);
    }
}
