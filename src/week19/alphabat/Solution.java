package week19.alphabat;

import java.util.*;

public class Solution {
    Map<Character, Integer> alphaCnt = new HashMap<>(); // 알파벳 별 덩어리 개수 저장
    Set<Character> result = new TreeSet<>(); // 외톨이 알파벳 저장

    public String solution(String input_string) {

        char prev = '\0'; // 이전 문자 초기화
        for(char c : input_string.toCharArray()){
            if(c != prev){
                alphaCnt.put(c,alphaCnt.getOrDefault(c,0) + 1);
                if(alphaCnt.get(c) > 1) result.add(c);
            }
            prev = c; // 현재 문자를 이전 문자로 설정
        }
        if(result.isEmpty()) return "N";

        StringBuilder answer = new StringBuilder();

        for(char r : result) {
            answer.append(r);
        }
        return answer.toString();
    }
}
