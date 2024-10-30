package week16.candygame;

import java.util.Scanner;

public class Main {
    static char[][] candies;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        candies = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next(); // 각 줄의 사탕 색상을 문자열로 입력받기
            candies[i] = line.toCharArray(); // 문자열을 char 배열로 변환하여 candies 에 저장
        }
        int maxCount = 0;
        // 교환 가능한 경우의 수 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽으로 교환
                if (j + 1 < n){
                    swap(i,j,i,j+1);
                    int nowCount = checkMaxCandies(n);
                    maxCount = Math.max(maxCount, nowCount);
                    swap(i, j, i, j+1);  // 원래대로 복구
                }
                // 아래쪽으로 교환
                if (i + 1 < n){
                    swap(i,j,i+1,j);
                    int nowCount = checkMaxCandies(n);
                    maxCount = Math.max(maxCount, nowCount);
                    swap(i, j, i+1, j); // 원래대로 복구
                }
            }
        }
        System.out.println(maxCount);

    }
    static void swap(int x1, int y1, int x2, int y2) {
        char temp = candies[x1][y1];
        candies[x1][y1] = candies[x2][y2];
        candies[x2][y2] = temp;
    }

    static int checkMaxCandies(int n) {
        int maxCount = 0;

        // 가로 최대 개수 확인
        for (int i = 0; i < n; i++) {
            int nowCount = 1; // 가로 확인 루프 초기화
            for (int j = 0; j < n - 1; j++) {
                if (candies[i][j] == candies[i][j + 1]) {
                    nowCount++;
                } else {
                    nowCount = 1;
                }
                maxCount = Math.max(maxCount, nowCount);
            }
        }

        // 세로 최대 개수 확인
        for (int i = 0; i < n; i++) {
            int nowCount = 1; // 세로 확인 루프 초기화
            for (int j = 0; j < n - 1; j++) {
                if (candies[j][i] == candies[j + 1][i]) {
                    nowCount++;
                } else {
                    nowCount = 1;
                }
                maxCount = Math.max(maxCount, nowCount);
            }
        }
        return maxCount;
    }
}
