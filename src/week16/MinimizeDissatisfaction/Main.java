package week16.MinimizeDissatisfaction;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 학생 수

        int[] scores = new int[n]; // 예상 등수

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(scores);// 예상 등수 정렬

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer += Math.abs(scores[i] - (i + 1));
        }
        System.out.println(answer);
    }
}
