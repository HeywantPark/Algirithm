package week0;

public class Recursive08 {
    static int[] arr = {1,3,5};
    // 재귀함수의 인자변수를 1개만 사용하여 3개값의 합을 구하세요
    public static void main(String[] args) {
        int sum = recursive(0);
        System.out.println(sum);
    }
    public static int recursive(int idx) {
        // basis part
        if (idx == arr.length) {
            return 0;
        }
        // inductive part
        return recursive(idx + 1)+arr[idx];
    }
}
