package week12.thegameofdeath;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int findK(int n, int k, int[] target) {
        // 방문 여부를 체크하는 배열
        boolean[] visited = new boolean[n];
        // BFS를 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 현재 사람 번호를 넣는다.
        queue.add(0);
        visited[0] = true;

        // BFS 시작
        int count = 1; // 0번이 이미 첫 번째로 부른다고 가정하므로 1부터 시작
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // cur 가 지목한 사람이 target[cur]이므로 그 사람을 탐색
            int next = target[cur];

            // 만약 next가 K 라면 count 반환
            if (next == k) {
                return count;
            }

            // 아직 방문하지 않은 사람이라면 큐에 넣고 방문 처리
            if (!visited[next]) {
                queue.add(next);
                visited[next] = true;
            }

            // 지목 횟수 증가
            count++;
        }

        // BFS가 끝났는데도 K를 찾지 못한 경우
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N: 사람의 수, K: 보성이의 번호
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 각 사람이 지목하는 사람의 번호 배열
        int[] target = new int[n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
        }

        // 0번이 불러야 하는 최소 M을 구함
        int result = findK(n, k, target);

        // 결과 출력
        System.out.println(result);

        sc.close();
    }
}

