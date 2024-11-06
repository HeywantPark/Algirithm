package week17.candidatekey;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        String[][] relation = {{"100","ryan","music","2"}
                ,{"200","apeach","math","2"}
                ,{"300","tube","computer","3"}
                ,{"400","con","computer","1"}
                ,{"500","muzi","music","3"}
                ,{"600","apeach","music","2"}};
        solution(relation);
    }
    static int answer = 0;
    public static int solution(String[][] relation) {

        powerSet(0,relation, new boolean[relation[0].length]);
        System.out.println(answer);
        return answer;
    }

    private static void powerSet(int idx, String[][] relation, boolean[] sel) {
        if(idx==relation[0].length) {
            if(isCandidate(relation,sel)) {
                answer++;
            }
            return;
        }
        // 최소성보장을 위해 false 부터한다
        sel[idx] = false;
        powerSet(idx+1,relation, sel);
        sel[idx] = true;
        powerSet(idx+1,relation, sel);

    }

    private static boolean isCandidate(String[][] relation, boolean[] sel) {
        Set<String> row = new HashSet<>();
        for (int r = 0; r < relation.length; r++) {
            String tmp = "";
            for (int c = 0; c < relation[r].length; c++) {
                if(sel[c]) tmp +=relation[r][c];
            }
            //System.out.println(tmp);
            row.add(tmp);
        }
        // 유일성 검사
        if(row.size()!=relation.length) return false;
        // 최소성검사
        if(!isMinumal(sel)) return false;
        //System.out.println("111111");

        return true;
    }

    static List<HashSet<Integer>> candidateList = new ArrayList<>();

    private static boolean isMinumal(boolean[] sel) {
        HashSet<Integer> cols = new HashSet<>();
        for (int i = 0; i < sel.length; i++) {
            if(sel[i]) cols.add(i);
        }

        for (HashSet<Integer> set : candidateList) {
            if(cols.containsAll(set)) return false;
        }

        candidateList.add(new HashSet<Integer>(cols));

        return true;
    }

}
