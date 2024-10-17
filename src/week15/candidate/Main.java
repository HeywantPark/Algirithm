package week15.candidate;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사진틀의 개수
        int k = sc.nextInt(); // 추천 횟수
        int[] studentNum = new int[k];

        for (int i = 0; i < k; i++) {
            studentNum[i] = sc.nextInt();
        }
        // 사진틀 만들기
        List<Integer> photo = new ArrayList<>();

        // 추천 횟수 저장 map
        Map<Integer, Integer> recomCount = new HashMap<>();

        for (int s : studentNum) {
            // 사진틀에 사진이 있는 경우 : 추천 횟수만 증가
            if (photo.contains(s)) {
                recomCount.put(s, recomCount.get(s) + 1);
            } else if (photo.size() < n) { // 사진틀에 빈 자리가 있는 경우
                photo.add(s);
                recomCount.put(s, 1);
            } else { // 사진틀이 꽉 찬 경우
                int recomMin = Integer.MAX_VALUE;
                int removeStudent = photo.get(0); // 초기화: 가장 먼저 들어간 학생으로 설정

                // 추천 횟수가 가장 적고 오래된 학생 찾기
                for (int p : photo) {
                    int count = recomCount.get(p);
                    if (count < recomMin) {
                        recomMin = count;
                        removeStudent = p;
                    } else if (count == recomMin) {
                        if (photo.indexOf(p) < photo.indexOf(removeStudent)) {
                            removeStudent = p;
                        }
                    }
                }

                // 가장 추천 횟수가 적고 오래된 학생 제거
                photo.remove((Integer) removeStudent);
                recomCount.remove(removeStudent);

                // 새로운 학생 추가
                photo.add(s);
                recomCount.put(s, 1);
            }
        }

        Collections.sort(photo); // 최종 후보들 정렬
        for (int p : photo) {
            System.out.print(p + " ");
        }
    }
}
