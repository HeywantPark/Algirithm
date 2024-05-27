package week0;

public class Recursive07 {
    static int[] arr = { 1, 3, 5 };

    public static void main(String[] args) {
        // 부분집합 구하기
        boolean[] sel = new boolean[arr.length];
        recursive(0, sel);
    }

    public static void recursive(int idx, boolean[] sel) {
        // basis part
        if (idx == sel.length) {
            // 선택된 요소들을 출력
            for (int i = 0; i < sel.length; i++) {
                if (sel[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        // inductive part
        // 현재 요소를 선택하는 경우
        sel[idx] = true;
        recursive(idx + 1, sel);

        // 현재 요소를 선택하지 않는 경우
        sel[idx] = false;
        recursive(idx + 1, sel);
    }
}
