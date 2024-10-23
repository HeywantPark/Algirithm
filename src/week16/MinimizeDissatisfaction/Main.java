package week16.MinimizeDissatisfaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 학생 수 입력
        int N = Integer.parseInt(br.readLine());

        // 예상 등수를 저장할 배열
        int[] expectedRanks = new int[N];

        // 예상 등수 입력
        for (int i = 0; i < N; i++) {
            expectedRanks[i] = Integer.parseInt(br.readLine());
        }

        // 예상 등수 정렬
        Arrays.sort(expectedRanks);

        long totalDissatisfaction = 0;

        // 불만도 계산: 예상 등수와 실제 등수 차이의 절댓값을 더함
        for (int i = 0; i < N; i++) {
            int actualRank = i + 1; // 실제 등수는 1등부터 N등까지
            totalDissatisfaction += Math.abs(expectedRanks[i] - actualRank);
        }

        // 총 불만도 출력
        System.out.println(totalDissatisfaction);
    }
}
