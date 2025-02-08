package week23.ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ballColor = br.readLine();

        int totalRed = 0, totalBlue = 0;
        for (int i = 0; i < n; i++) {
            if (ballColor.charAt(i) == 'R') totalRed++;
            else totalBlue++;
        }

        // 왼쪽에서부터 연속된 같은 색 공 개수 카운트
        int leftRed = 0, leftBlue = 0;
        for (int i = 0; i < n && ballColor.charAt(i) == 'R'; i++) leftRed++;
        for (int i = 0; i < n && ballColor.charAt(i) == 'B'; i++) leftBlue++;

        // 오른쪽에서부터 연속된 같은 색 공 개수 카운트
        int rightRed = 0, rightBlue = 0;
        for (int i = n - 1; i >= 0 && ballColor.charAt(i) == 'R'; i--) rightRed++;
        for (int i = n - 1; i >= 0 && ballColor.charAt(i) == 'B'; i--) rightBlue++;

        // 최소 이동 횟수 계산
        int minMoves = Math.min(
                Math.min(totalRed - leftRed, totalRed - rightRed), // R을 왼쪽/오른쪽으로 몰기
                Math.min(totalBlue - leftBlue, totalBlue - rightBlue) // B를 왼쪽/오른쪽으로 몰기
        );

        System.out.println(minMoves);
    }
}
