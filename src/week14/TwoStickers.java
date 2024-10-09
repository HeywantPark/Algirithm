package week14;

import java.util.Scanner;

public class TwoStickers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int[][] stickers = new int[N][2];

        for (int i = 0; i < N; i++) {
            stickers[i][0] = sc.nextInt();
            stickers[i][1] = sc.nextInt();
        }

        int maxArea = 0;

        // 모든 스티커 조합 탐색
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int R1 = stickers[i][0];
                int C1 = stickers[i][1];
                int R2 = stickers[j][0];
                int C2 = stickers[j][1];

                // 첫 번째 스티커의 모든 회전 형태
                for (int[] dim1 : new int[][]{{R1, C1}, {C1, R1}}) {
                    int a = dim1[0];
                    int b = dim1[1];

                    // 두 번째 스티커의 모든 회전 형태
                    for (int[] dim2 : new int[][]{{R2, C2}, {C2, R2}}) {
                        int c = dim2[0];
                        int d = dim2[1];

                        // 네 가지 배치 방식 확인
                        if ((a + c <= H && Math.max(b, d) <= W) || (a + c <= W && Math.max(b, d) <= H)) {
                            maxArea = Math.max(maxArea, a * b + c * d);
                        }
                        if ((a + d <= H && Math.max(b, c) <= W) || (a + d <= W && Math.max(b, c) <= H)) {
                            maxArea = Math.max(maxArea, a * b + c * d);
                        }
                        if ((b + c <= H && Math.max(a, d) <= W) || (b + c <= W && Math.max(a, d) <= H)) {
                            maxArea = Math.max(maxArea, a * b + c * d);
                        }
                        if ((b + d <= H && Math.max(a, c) <= W) || (b + d <= W && Math.max(a, c) <= H)) {
                            maxArea = Math.max(maxArea, a * b + c * d);
                        }
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}

