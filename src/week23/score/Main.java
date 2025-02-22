package week23.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(scores);

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(scores[i] - (i + 1));
        }
        System.out.println(result);
    }
}
