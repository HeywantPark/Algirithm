package week6.wordSearch;

public class Solution {
    private int rowLength;
    private int colLength;
    private static int[] dr = { 0, 1, 0, -1 };
    private static int[] dc = { -1, 0, 1, 0 };
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;

        visited = new boolean[rowLength][colLength];

        for(int r = 0; r < rowLength; r++){
            for(int c = 0; c < colLength; c++ ){
                if(board[r][c] == word.charAt(0)) {
                    visited[r][c] = true;
                    if(checkNextVer(r,c,board,word,1)) return true;
                    visited[r][c] = false;

                }
            }
        }
        return false;
    }
    boolean checkNextVer(int r, int c,char[][] board,String word ,int startVer){

        if (startVer == word.length()) {
            return true;
        }

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(inRange(nr,nc)) {
                if( !visited[nr][nc] && board[nr][nc] == word.charAt(startVer)) {
                    visited[nr][nc] = true;
                    if(checkNextVer(nr,nc,board,word,startVer+1)) return true;
                    visited[nr][nc] = false;
                }
            }
        }
        return false;
    }
    boolean inRange(int r, int c) {
        return (r >= 0) && (r < rowLength) && (c >= 0) && (c < colLength);
    }
}
