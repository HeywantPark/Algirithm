package week12.permutation;

import java.util.Scanner;

public class Main {
    public int Solution(int n, int[] permutation) {
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        int[] perm = new int[n + 1];

        for (int i = 0; i < permutation.length; i++) {
            perm[i + 1] = permutation[i];
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            dfs(visited,perm,i);
            count++;
        }
        return count;
    }
    void dfs(boolean[] visited, int[] perm, int cur) {
        visited[cur] = true;
        int next = perm[cur];
        for (int i = 1; i <= perm.length; i++) {
            if (!visited[next]) {
                dfs(visited,perm,next);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스의 수 입력 받기
        int T = sc.nextInt();

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();  // 순열의 크기 입력
            int[] permutation = new int[n];

            // 순열 입력 받기
            for (int i = 0; i < n; i++) {
                permutation[i] = sc.nextInt();
            }

            // 현재 테스트 케이스에 대한 결과 계산
            Main main = new Main();
            int result = main.Solution(n, permutation);
            System.out.println(result);  // 각 테스트 케이스의 결과 출력
        }
        sc.close();
    }
}
