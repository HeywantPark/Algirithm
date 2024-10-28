package week0;

public class Recursive09 {
    // arr 더하기와 곱하기를 리턴제귀로 구해보세요
    static int[] arr = {5,3,1};

    public static void main(String[] args) {
        int res = recursive(0);
        System.out.println(res);
    }
    public static int recursive(int idx) {
        // basis part
        if (idx == arr.length) {
            return 1;
        }
        // inductive part
        return Math.max(arr[idx] + recursive(idx + 1) ,arr[idx] * recursive(idx +1));
    }
}
