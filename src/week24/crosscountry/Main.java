package week24.crosscountry;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] team = new int[n];

            for (int i = 0; i < n; i++) {
                team[i] = sc.nextInt();
            }
            // 팀 별로 선수 등수를 저장
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(team[i], new ArrayList<>());
                map.get(team[i]).add(i);
            }
            // 유효한 팀만 필터링
            Map<Integer, List<Integer>> validTeams = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                if(entry.getValue().size() >= 6) {
                    validTeams.put(entry.getKey(), entry.getValue());
                }
            }
            // 점수 매기기
            int[] scores = new int[n];
            Arrays.fill(scores, -1);

            int rank = 1;
            for (int i = 0; i < n; i++) {
                if(validTeams.containsKey(team[i])) {
                    scores[i] = rank++;
                }
            }
            // 4번째까지 점수 합산
            int winner = getWinner(validTeams, scores);
            System.out.println(winner);
        }
    }

    private static int getWinner(Map<Integer, List<Integer>> validTeams, int[] scores) {
        int minScore = Integer.MAX_VALUE;
        int tieBreaker = Integer.MAX_VALUE;
        int winner = -1;
        for (Map.Entry<Integer, List<Integer>> entry : validTeams.entrySet()) {
            int teamId = entry.getKey();
            List<Integer> list = entry.getValue();

            int score = 0;
            for (int i = 0; i < 4; i++) {
                score += scores[list.get(i)];
            }
            int fifthScore = scores[list.get(4)];

            if(score < minScore) {
                minScore = score;
                tieBreaker = fifthScore;
                winner = teamId;
            } else if (score == minScore) {
                if(tieBreaker > fifthScore) {
                    tieBreaker = fifthScore;
                    winner = teamId;
                }
            }
        }
        return winner;
    }
}
