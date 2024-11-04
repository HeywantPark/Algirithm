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


        // Collections 를 사용한 정렬
        Collections.sort(words, (a,b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length(); // 길이 순 정렬
            } else {
                return a.compareTo(b); // 사전 순 정렬
            }
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}
