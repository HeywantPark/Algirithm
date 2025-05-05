package week26.cuttingtree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] tree = new int[n];

        for (int i = 0; i < n; i++) {
            tree[i] = sc.nextInt();
        }

        Arrays.sort(tree);

        int left = 0;
        int right = tree[n - 1];
        int answer = 0;


        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < tree.length; i++) {
                sum += Math.max(tree[i] - mid, 0);
            }
            if (sum >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
