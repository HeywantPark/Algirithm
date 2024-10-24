package week16.nouturn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 문제의 input을 받습니다.
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 3. 지도 위의 모든 길에서 연결된 길의 개수를 구해 막다른 길인지 판단합니다.
        boolean needUTurn = false;
        outerLoop:
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    if (calcWays(i, j) <= 1) {
                        needUTurn = true;
                        break outerLoop;
                    }
                }
            }
        }

        // 결과 출력
        if (needUTurn) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    // 2. 막다른 길을 탐색하기 위해 연결된 길의 개수를 구하는 함수를 구현합니다.
    static int calcWays(int x, int y) {
        int way = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                continue;
            }
            if (board[nx][ny] == '.') {
                way++;
            }
        }
        return way;
    }
}
