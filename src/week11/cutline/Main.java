package week11.cutline;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        Integer[] scores = new Integer[N];

        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }
        // 내림차순으로 정렬
        Arrays.sort(scores, Collections.reverseOrder());

        // 상위 K번째 학생의 점수를 커트라인으로 출력
        System.out.println(scores[K - 1]);

        sc.close(); // Scanner 자원 해제
    }
}
