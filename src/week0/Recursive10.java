package week0;

public class Recursive10 {
    static long [] memo;
    public static void main(String[] args) {
        int n = 50;
        memo = new long [n+1];
        System.out.println(fiboDp(n));
    }
    // 상향식
    private static long fiboDp(int n) {

        memo[1] = 1;
        memo[2] = 1;

        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
    private static long recursive (int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return recursive(n-1) + recursive(n-2);
    }
    private static long recursiveMemo(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (memo[n] != 0) return memo[n];
        return  memo[n] = recursiveMemo(n-1) + recursiveMemo(n-2);
    }
    /*
     * dp 좋은문제
     * 1. 일로만들기
     * 2. 일이삼더하기
     * 3. 계단오르기
     * 4. 타일링 2n
     * 5. 가장긴감소하는부분수열
     * 6. 퇴사 1, 2
     * 7. 내리막길
     */
}
