package week2.valid_parenthese;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        //✅ 문자열 s를 문자 단위로 순회한다.
        for (char p : s.toCharArray()) {
            switch (p) {
                //✅ 현재 문자가 열린 괄호라면, stack에 그에 대응되는 닫힌 괄호를 추가한다.
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    //✅ 현재 문자가 닫힌 괄호일 때, 스택의 마지막 문자가 현재 문자와 같다면,
                    if (!stack.isEmpty() && stack.peek() == p) {
                        //✅ stack의 마지막 문자를 제거한다.
                        stack.pop();
                        //✅ 문자열 유효성 조건을 위배하면 false를 반환한다.
                    } else {
                        return false;
                    }
            }
        }
        //✅ 문자열 순회를 종료하고, stack이 비어있으면 true, 아니라면 false를 반환한다.
        return stack.isEmpty();
    }
}
