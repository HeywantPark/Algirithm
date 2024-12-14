package week20.failrate;

import java.util.*;

public class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> fail = new HashMap<>(); // 스테이지 별 실패 수 저장

        // 각 스테이지에 머물러 있는 플레이어 수 계산
        for (int s : stages) {
            if (s <= N) {
                fail.put(s, fail.getOrDefault(s, 0.0) + 1.0);
            }
        }

        // 각 스테이지에 도달한 플레이어 수 계산
        int[] arr = new int[N + 1]; // 각 스테이지별 도달 수
        for (int s : stages) {
            for (int i = 1; i <= Math.min(s, N); i++) {
                arr[i]++;
            }
        }

        // 스테이지 실패율 계산
        Map<Integer, Double> rate = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] != 0) {
                rate.put(i, fail.getOrDefault(i, 0.0) / arr[i]); // 실패율 계산
            } else {
                rate.put(i, 0.0); // 도달한 플레이어가 없으면 실패율 0
            }
        }

        // 실패율 기준으로 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(rate.entrySet());
        entryList.sort((e1, e2) -> {
            int compare = Double.compare(e2.getValue(), e1.getValue());
            if (compare == 0) { // 실패율이 같을 경우 스테이지 번호로 오름차순 정렬
                return Integer.compare(e1.getKey(), e2.getKey());
            }
            return compare;
        });

        // 정렬된 키를 int 배열에 저장
        int[] sortedKeys = new int[entryList.size()];
        for (int i = 0; i < entryList.size(); i++) {
            sortedKeys[i] = entryList.get(i).getKey();
        }

        return sortedKeys;
    }
}
