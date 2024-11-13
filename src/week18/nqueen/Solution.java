package week18.nqueen;

public class Solution {
    int[] queens;
    int count;
    public int solution(int n) {
        queens = new int[n];
        count = 0;
        placeQueen(0,n);
        return count;
    }
    public void placeQueen(int row, int n){
        // basis part
        if(row == n){
            count++;
            return;
        }
        // indective part
        for (int col = 0; col < n; col++) { // 각 열에 퀸 배치 시도
            if (isValid(row, col)) { // 조건을 만족하는지 체크
                queens[row] = col; // 퀸 배치
                placeQueen(row + 1, n); // 다음 행으로 이동
            }
        }
    }
    public boolean isValid(int row, int col){
        for(int i = 0; i < row; i++){
            if(queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)){
                return false;
            }
        }
        return true;
    }
}
