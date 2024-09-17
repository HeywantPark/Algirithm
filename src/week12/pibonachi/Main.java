package week12.pibonachi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int[] memo = new int[n + 1];
        System.out.println(dp(n, memo));
    }

    static int dp(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != 0) return memo[n]; // 이미 계산한 값이면 반환

        memo[n] = dp(n - 1, memo) + dp(n - 2, memo); // 값 저장 후 반환
        return memo[n];
    }
}
