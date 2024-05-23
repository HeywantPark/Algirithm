package week0;

public class Recursive03 {
    public static void main(String[] args) {
        // 1 ~ 3 더한값과 곱한값을 구하세요
        // 단 함수의 인자를 idx, val 변수 2개만 사용해서 구해보세요
        recursive(1,1);
    }
    public static void recursive(int idx, int val) {
        // basis part
        if (idx > 3) {
            System.out.println("val : " + val); // 8번 실행 됌
            return;
        }
        // inductive part
        recursive(idx+1, idx+val);
        recursive(idx+1, idx*val);
    }
}
