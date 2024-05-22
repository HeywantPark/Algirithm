package week0;

public class Recursive01 {
    // 1 ~ 5 더하는 재귀로직을 구현하세요
    public static void main(String[] args) {
        recursive(1,0);
    }

    private static void recursive(int idx, int sum) {
        // basis part
        if (idx > 5) {
            System.out.println(sum);
            return;
        }
        // inductive part
        sum += idx;
        recursive(idx+1, sum);
    }
}
