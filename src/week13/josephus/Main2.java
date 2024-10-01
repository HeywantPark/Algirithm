package week13.josephus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 인원 수
        int K = sc.nextInt(); // K번째 제거

        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (queue.size() > 1) {
            // K-1번 만큼 큐의 앞에서 제거하고 뒤로 이동
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }
            // K번째 사람 제거
            result.append(queue.poll()).append(", ");
        }

        // 마지막 남은 사람 추가
        result.append(queue.poll()).append(">");

        System.out.println(result);
    }
}
