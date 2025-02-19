package week22.rotatesushi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 초밥 접시의 수
        int d = sc.nextInt(); // 초밥의 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 수
        int c = sc.nextInt(); // 쿠폰번호

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = sc.nextInt();
        }
        int ans = getMaxSushiVariety(n, d, k, c, sushi);
        System.out.println(ans);
    }

    private static int getMaxSushiVariety(int n, int d, int k, int c, int[] sushi) {
        int[] count = new int[d + 1]; // 각 초밥의 개수를 저장하는 배열
        int uniqueCount = 0; // 현재 초밥 종류 수
        int maxCount = 0;


        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) uniqueCount++; // 새로운 초밥 종류 등장
            count[sushi[i]]++;
        }

        if (count[c] == 0) {
            maxCount = uniqueCount + 1; // 쿠폰 초밥이 없으면 +1 추가
        } else {
            maxCount = uniqueCount; // 이미 포함되어 있으면 그대로 유지
        }



        for (int i = 0; i < n; i++) {
            int removeIdx = i; // 제거할 초밥 위치
            int addIdx = (i + k) % n; // 추가할 초밥 위치 (회전 고려)

            // 제거할 초밥 반영
            count[sushi[removeIdx]]--;
            if (count[sushi[removeIdx]] == 0) uniqueCount--; // 초밥 종류 감소

            // 추가할 초밥 반영
            if (count[sushi[addIdx]] == 0) uniqueCount++; // 새로운 초밥 종류 등장
            count[sushi[addIdx]]++;

            // 쿠폰 초밥 포함 여부 확인 후 최대값 갱신
            int tempCount;
            if (count[c] == 0) {
                tempCount = uniqueCount + 1; // 쿠폰 초밥이 없으면 +1 추가
            } else {
                tempCount = uniqueCount; // 이미 포함되어 있으면 그대로 유지
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
            }

        }

        return maxCount;
    }
}
