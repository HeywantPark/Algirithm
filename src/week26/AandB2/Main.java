package week26.AandB2;

import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();
        dfs(s,t);

        System.out.println(answer);


    }
    private static void dfs(String s, String t) {

        if (t.length() == s.length()){
            if (t.equals(s)) {
                answer = 1;
            }
            return;
        }
        // 1. 문자열 맨 뒤가 A일 경우 A 를 제거
        if (t.endsWith("A")){
            dfs(s,t.substring(0,t.length()-1));
        }
        // 2. 문자열 맨 앞에 B일 경우 문자열을 뒤집고 맨 뒤의 B를 제거
        if (t.startsWith("B")){
            dfs(s, new StringBuilder(t.substring(1)).reverse().toString());
        }
    }

}
