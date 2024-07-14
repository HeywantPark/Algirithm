package week2.turn_parenthese;

import java.util.*;

public class Solution {
    public int solution(String s) {
        String ds = s + s;
        int answer = 0;
        for(int i = 0; i < s.length(); i++){
            if(isValid(ds.substring(i , s.length() + i))) answer++;
        } return answer;
    }
    private boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c =='[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char target = stack.pop();
                if (c == ')' && target != '(') return false;
                if (c == '}' && target != '{') return false;
                if (c == ']' && target != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
