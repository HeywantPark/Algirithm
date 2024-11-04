package week17.wordsorted;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.next()); // 중복제거를 위해 set에 저장
        }
        List<String> words = new ArrayList<>(set); // 리스트로 변환

        words.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length(); // 길이 기준 정렬
            } else {
                return o1.compareTo(o2); // 사전 순 정렬
            }
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}
