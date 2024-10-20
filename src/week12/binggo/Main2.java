package week12.binggo;

import java.util.List;

public class Main2 {
    public int bingo(int[][] board, List<Integer> target) {

        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < target.size(); i++) {
            int cur = target.get(i);

            //board 에 답이 있는지 체크
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (board[j][k] == cur) {
                        visited[k][j] = true;
                        //bingoCheck
                    }
                }
            }
        }
    }

}
