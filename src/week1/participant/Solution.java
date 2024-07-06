package week1.participant;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String disComplete(String[] participant, String[] completion) {
        // 해시맵을 사용한 풀이
        Map<String, Integer> counter = new HashMap<>();
        for (String p : participant) {
            counter.put(p, counter.getOrDefault(p, 0) + 1);
        }
        for (String c : completion) {
            counter.put(c, counter.getOrDefault(c, 0) - 1);
        }
        for (String k : counter.keySet()) {
            if (counter.get(k) != 0) {
                return k;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.disComplete(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"});
        System.out.println(result);
    }
}
