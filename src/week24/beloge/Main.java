package week24.beloge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int[] visitor = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            visitor[i] = Integer.parseInt(line[i]);
        }
        // 초기 윈도우 설정
        int curSum = 0;
        for (int i = 0; i < x; i++) {
            curSum += visitor[i];
        }
        int maxSum = curSum;
        int count = 1;

        // 슬라이딩 윈도우 적용
        for(int i = x; i < n; i++) {
            curSum = curSum - visitor[i - x] + visitor[i];

            if(curSum > maxSum) {
                maxSum = curSum;
                count = 1;
            } else if(curSum == maxSum) {
                count++;
            }
        }
        if(maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum + "\n" + count);
        }
    }
}
