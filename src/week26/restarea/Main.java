package week26.restarea;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 기존에 세워진 휴게소의 개수
        int m = sc.nextInt(); // 새로 지어야할 휴게소의 개수
        int l = sc.nextInt(); // 고속도로 길이
        int[] rest = new int[n + 2];

        rest[0] = 0;
        rest[n + 1] = l;

        for (int i = 1; i <= n; i++) {
            rest[i] = sc.nextInt();
        }
        Arrays.sort(rest);

        int left = 1;
        int right = l - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 1; i < rest.length; i++) {
                sum += (rest[i] - rest[i - 1] - 1) / mid;
            }
            if (sum > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
