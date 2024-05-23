package week0;

public class Recursive02 {
    public static void main(String[] args) {
        // 1 ~ 5 더한값과  곱한값을 구하세요
        recursive(1,0,1);
    }
    public static void recursive(int idx, int sum, int cross) {
        // basis part
        if (idx > 5) {
            System.out.println("sum = " + sum + ", cross = " + cross);
            return;
        }
        // inductive part
        recursive(idx+1, sum+idx, cross*idx);
    }
}
