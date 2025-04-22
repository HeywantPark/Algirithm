package week25.hateoverlap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] count = new int[100001]; // 수열 안의 숫자를 담을 배열

        int start = 0;
        int max = 0;
        for (int end = 0; end < n; end++) {
            count[nums[end]]++;

            //만약 어떤 숫자가 k가 이상 나왔을 경우 윈도우 수 줄이기
            while(count[nums[end]] > k) {
                count[nums[start]]--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        System.out.println(max);
    }
}
