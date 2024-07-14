package week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class CorrectParentheses {
    boolean solution(String s) {
        boolean answer = true;
        // stack을 생성한다.
        Deque<Character> stack = new ArrayDeque<>();
        // for문을 사용하여 문자열 s의 문자 하나하나에 접근한다.
        for (int i = 0; i < s.length(); i++) {
            // 문자열에서 가져온 문자를 char타입의 변수에 저장한다.
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        answer = stack.isEmpty();
        return answer;
    }
    public static void main(String[] args) {
        CorrectParentheses correctParentheses = new CorrectParentheses();

        // 테스트 케이스
        String[] testCases = {
                "()",
                "()()",
                "(())",
                "(()",
                "())",
                "((()))",
                "(()))",
                "",
                "(((((",
                "))))"
        };
        // 테스트 실행
        for (String testCase : testCases) {
            boolean result = correctParentheses.solution(testCase);
            System.out.println("Input: " + testCase + " => Output: " + result);
        }
    }
}
