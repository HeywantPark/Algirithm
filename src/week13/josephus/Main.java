package week13.josephus;

import java.util.*;

public class Main {
    public String solution(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();

        // 1부터 n까지 queue 에 저장
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        // 답을 저장할 리스트
        StringBuilder answer = new StringBuilder();
        answer.append("<");

        while (!queue.isEmpty()) {

            for (int i = 0; i < k-1; i++) {
                // k-1번째까지는 queue 의 뒤로 보냄
                int next = queue.poll();
                queue.offer(next);
            }
            // k번째 사람은 제거
            answer.append(queue.poll());
            if (!queue.isEmpty()) {
                answer.append(", ");
            }
        }
        answer.append(">");
        return answer.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        Main main = new Main();
        System.out.println(main.solution(n, k));
    }
}
