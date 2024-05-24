package week0;

import java.util.Arrays;

public class Recursive04 {
    static int[] arr = {1,3,5};
    static int[] sel = new int[2];

    public static void main(String[] args) {
        // 조합
        // arr 배열에서 2개의 값을 고르는 경우를 구하세요
        recursive(0,0);
    }
    public static void recursive(int idx, int k) {
        // basis part
        if (k == sel.length) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        if (idx == arr.length) return; // 더이상 원본 배열에 고를 값이 없는 경우

        // inductive part
        sel[k] = arr[idx];
        recursive(idx+1, k+1); // 다음 인덱스 값을 선택하는 경우
        recursive(idx+1, k); // 다음 인덱스 값을 선택 안하는 경우
    }
}
