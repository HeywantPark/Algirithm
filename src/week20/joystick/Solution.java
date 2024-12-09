package week20.joystick;

public class Solution {
    public int solution(String name) {

        int n = name.length();
        int moveCount = 0;
        int minMove = n - 1;


        for (int i = 0; i < n; i++){
            // 1. 알파벳 이동 횟수
            char c = name.charAt(i);
            moveCount += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 커서 이동 경로 계산
            int nextIndex = i + 1;
            // 다음 문자가 A라면 계속 이동
            while(nextIndex < n && name.charAt(nextIndex) == 'A'){
                nextIndex++;
            }
            // 최소 이동 거리 갱신
            minMove = Math.min(minMove, i + n - nextIndex + Math.min(i, n - nextIndex));
        }
        // 3. 결과 반환 (알파벳 변경 횟수 + 커서 이동 횟수)
        return moveCount + minMove;
    }
}
