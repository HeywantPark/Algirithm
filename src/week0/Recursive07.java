package week0;

import java.util.Arrays;

public class Recursive07 {
    static int arr[] = { 1, 3, 5 };

    public static void main(String[] args) {
        // 부분집합의 집합 powerSet
        recursive(0,0,new boolean[arr.length]);


    }
    public static void recursive(int idx,int size,boolean[] sel) {
        // basis part
        if (idx == sel.length) {
            for (int i = 0; i< sel.length; i++) {
                if (sel[i]) {
                    System.out.println(arr[i] + " ");
                }
            }
            System.out.println();
            return;

        }
        // inductive part
        sel[idx] = true;
        recursive(idx+1,size+1,sel);
        sel[idx] = false;
        recursive(idx+1,size,sel);
    }
}
