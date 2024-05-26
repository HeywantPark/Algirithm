package week0;

import java.util.Arrays;

public class Recursive06 {
    public static void main(String[] args) {
        // 중복 순열 , 3개 중에서 3개 뽑는 경우 : 순서 o , 중복 x
        int[] arr = {1, 2, 3};
        int[] sel = new int[arr.length];
        boolean[] v = new boolean[arr.length];
        recursive(arr, sel, 0,v);
    }
    public static void recursive(int[] arr, int[] sel, int index,boolean[] v) {
        // basis part
        if (index == sel.length) {
            System.out.println(Arrays.toString(sel));
            return;
        }
        // inductive part
        for (int i = 0; i < arr.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[index] = arr[i];
                recursive(arr, sel, index + 1,v);
                v[i] = false;
            }
        }
    }
}
