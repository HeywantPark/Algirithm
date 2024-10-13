package week14.treedivision;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heigh = new int[n];
        int[] growh = new int[n];

        // 첫 번째 줄에서 나무의 초기 길이 입력
        for (int i = 0; i < n; i++) {
            heigh[i] = sc.nextInt();
        }

        // 두 번째 줄에서 나무의 성장률 입력
        for (int i = 0; i < n; i++) {
            growh[i] = sc.nextInt();
        }

        // 성장률과 초기 높이를 저장할 2차원 배열 생성
        int[][] tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            tree[i][0] = growh[i]; // 성장률
            tree[i][1] = heigh[i]; // 초기 높이
        }

        // 성장률 기준 내림차순 정렬
        Arrays.sort(tree, Comparator.comparingInt(a -> a[0]));

        // 최대 나무 양 계산
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += (long) tree[i][0] * i + tree[i][1];
        }

        System.out.println(count);
    }
}
