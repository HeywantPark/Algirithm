package week20.lottoGrade;

public class Solution {
    int[] answer = new int[2];
    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0;
        int lottoCnt = 0;

        for (int l : lottos){
            if(l == 0) {
                zeroCnt++;
                continue;
            } for (int w : win_nums){
                if(l == w) lottoCnt++;
            }
        }

        answer[0] = getGrade(lottoCnt + zeroCnt);
        answer[1] = getGrade(lottoCnt);

        return answer;
    }
    public int getGrade(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
