package week19.zero;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();

            if (a != 0) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
