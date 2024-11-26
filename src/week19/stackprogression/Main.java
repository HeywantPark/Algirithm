package week19.stackprogression;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int cur = 1;
        boolean flag = true;

        for (int num : arr) {
            while (cur <= num) {
                stack.push(cur++);
                result.append("+\n");
            }
            if (stack.peek() == num) {
                stack.pop();
                result.append("-\n");
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(result);
        } else {
            System.out.println("NO");
        }
    }
}
