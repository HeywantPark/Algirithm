package week11.heightandweight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[][] persons = new int[N][2];

        for (int i = 0; i < N; i++) {
            persons[i][0] = sc.nextInt(); // 몸무게
            persons[i][1] = sc.nextInt(); // 키
        }

        int[] result = calc(persons, N);

        for (int r : result) {
            System.out.print(r + " ");  // 결과 출력 시, 덩치 등수 그대로 출력
        }
    }

    private static int[] calc(int[][] persons, int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = 1;  // 모든 사람의 기본 등수는 1로 설정
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 자신보다 덩치가 더 큰 사람을 찾았을 때, 등수를 증가시킴
                    if (persons[i][0] < persons[j][0] && persons[i][1] < persons[j][1]) {
                        result[i]++;  // 덩치가 더 큰 사람을 찾으면 등수를 증가시킴
                    }
                }
            }
        }
        return result;
    }
}
