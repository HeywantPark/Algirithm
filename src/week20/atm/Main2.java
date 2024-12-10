package week20.atm;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = sc.nextInt();
        }
        Arrays.sort(times);

        int total = 0;
        int curSum = 0;

        for (int time : times){
            curSum += time;
            total += curSum;
        }
        System.out.println(total);
    }
}
