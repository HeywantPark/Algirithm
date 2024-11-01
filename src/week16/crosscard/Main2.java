package week16.crosscard;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받은 숫자를 공백 없이 이어 붙인 형태로 저장
        String inputNumber = sc.next().replace(" ", "");
        int inputClockNumber = makeClockNumber(inputNumber);

        int ans = 1; // 몇 번째 시계수인지 기록

        // 2. 1111부터 입력된 시계수까지 탐색
        for (int i = 1111; i < inputClockNumber; i++) {
            if (!includeZero(i)) { // 3. 0이 포함되어 있지 않은지 확인
                int nowClockNumber = makeClockNumber(String.valueOf(i));
                if (nowClockNumber == i) { // 4. 현재 수가 시계수인지 확인
                    ans++;
                }
            }
        }

        System.out.println(ans);
        sc.close();
    }

    // 2. 시계수를 계산하는 함수
    public static int makeClockNumber(String number) {
        int res = 9999;
        int[] arr = new int[4];

        // String을 int 배열로 변환
        for (int i = 0; i < 4; i++) {
            arr[i] = number.charAt(i) - '0';
        }

        // 시계 방향으로 네 자리 수 만들기
        for (int i = 0; i < 4; i++) {
            int now = arr[i] * 1000 + arr[(i + 1) % 4] * 100 + arr[(i + 2) % 4] * 10 + arr[(i + 3) % 4];
            res = Math.min(res, now);
        }
        return res;
    }

    // 3. 0이 포함되어 있는지 확인하는 함수
    public static boolean includeZero(int number) {
        String n = Integer.toString(number);
        return n.contains("0");
    }
}

