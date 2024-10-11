package week14.inequality;

import java.util.*;

public class Main {

    static int k;
    static String[] arr;
    static boolean[] visited = new boolean[10];
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input 을 입력받는다.
        k = sc.nextInt();
        arr = new String[k]; //부등호 배열

        for (int i = 0; i < k; i++) {
            arr[i] = sc.next();
        }
        //backTrack 을 실행한다.
        backTrack("",0);

        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));
        System.out.println(result.get(0));


    }
    private static void backTrack(String num,int digit) {
        if (digit == k + 1) {
            result.add(num);
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (!visited[i]) {
                //  자릿수가 0 이거나 부등호 검사를 통과했을 때만 선택
                if(digit == 0 || isValid(num.charAt(digit - 1) - '0', i , arr[digit - 1])) {
                    visited[i] = true;
                    backTrack(num + i,digit + 1);
                    visited[i] = false;
                }
            }
        }
    }
    // 부등호 검사
    private static boolean isValid(int a, int b,String arr) {
        if (arr.equals("<")) return a < b;
        return a > b;
    }
}
