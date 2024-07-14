package week2.valid_parenthese;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        // Character 타입을 저장할 스택 생성
        Deque<Character> stack = new ArrayDeque<>();
        // for 문을 돌며 문자열 검사
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            // 여는 괄호인 경우 스택에 푸시
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 스택이 비어있다면 잘못된 괄호 문자열이므로 false 반환
                if (stack.isEmpty()) return false;
                // 스택의 맨 위 요소를 꺼내서 현재 닫는 괄호와 비교
                char top = stack.pop();
                // 닫는 괄호와 매칭되지 않으면 false 반환
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        // 스택이 비어 있으면 모든 괄호가 올바르게 매칭된 것이므로 true 반환
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스
        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
                "",
                "[",
                "]",
                "[()]{}{[()()]()}",
                "[(])"
        };

        // 테스트 실행
        for (String testCase : testCases) {
            boolean result = solution.isValid(testCase);
            System.out.println("Input: " + testCase + " => Output: " + result);
        }
    }
}
