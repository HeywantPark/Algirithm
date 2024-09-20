package week12.make1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public int solution(int n) {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];  // 방문 체크 배열
        int count = 0;

        queue.add(n);
        visited[n] = true;  // n에 대해 방문 처리

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == 1) return count;  // 1이 되었을 때 종료

                // 3으로 나눌 수 있는 경우
                if (cur % 3 == 0) {
                    int next = cur / 3;
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;  // 방문 처리
                    }
                }
                // 2로 나눌 수 있는 경우
                if (cur % 2 == 0) {
                    int next = cur / 2;
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;  // 방문 처리
                    }
                }
                // 1을 빼는 경우
                int next = cur - 1;
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;  // 방문 처리
                }
            }
            count++;  // 한 레벨이 끝날 때마다 연산 횟수 증가
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Main().solution(n));
    }
}
