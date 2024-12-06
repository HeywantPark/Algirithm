package week19.gymclothes;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] have = new int[n + 1];

        // 체육복 1개씩 초기화
        for(int i = 1; i <= n; i++){
            have[i] = 1;
        }
        // 도난당한 학생 처리
        for (int l : lost) {
            have[l]--;
        }
        // 여분이 있는 학생 처리
        for (int r : reserve) {
            if(have[r] == 0) { // 여분이 있지만 자신이 도난당한 경우
                have[r] = 1;
            } else {
                have[r]++;
            }
        }
        // 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if(have[i] == 0) {
                if (i > 1 && have[i - 1] == 2){
                    have[i]++;
                    have[i - 1]--;
                } else if (i < n && have[i + 1] == 2){
                    have[i]++;
                    have[i + 1]--;
                }
            }
        }
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(have[i] >= 1) answer++;
        }
        return answer;
    }
}
