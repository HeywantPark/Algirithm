package week11.numbersort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄에서 단어의 개수 N 입력받기
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비

        // 단어들을 저장할 Set (중복 제거를 위해 TreeSet 사용)
        Set<String> set = new HashSet<>();

        // N개의 단어 입력받아 Set에 추가
        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            set.add(word); // 중복을 자동으로 제거
        }

        // Set을 List로 변환
        List<String> words = new ArrayList<>(set);

        // 길이와 사전 순으로 정렬
        Collections.sort(words, Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        // 결과 출력
        for (String word : words) {
            System.out.println(word);
        }
    }
}
