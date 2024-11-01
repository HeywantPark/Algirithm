package week16.crosscard;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }
        // 4개의 시계수 만들기
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int clockNum = getClockNum(nums,i);
            minNum = Math.min(minNum,clockNum);
        }
        int count = 0;
        for (int i = 1111; i <= minNum; i++) {
            if (!isZero(i) && isClockNum(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
    // 주어진 수가 시계수인지 확인
    private static boolean isClockNum(int num) {
        String n = String.valueOf(num);
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = n.charAt(i) - '0';
        }
        int minClockNum = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int clockNum = getClockNum(digits,i);
            minClockNum = Math.min(minClockNum,clockNum);
        }
        return minClockNum == num;
    }

    // nums 배열에서 시계 방향으로 네 자리 수 생성
    static int getClockNum(int[] nums, int start) {

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = result * 10 + nums[(start + i) % 4];
        }
        return result;
    }
    static boolean isZero(int i) {
        String n = Integer.toString(i);

        if(n.contains("0")) {
            return true;
        }
        return false;
    }
}

