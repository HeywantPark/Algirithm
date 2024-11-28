package week19.keypad;

public class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = {
                {3,1}, // 0
                {0,0},{0,1},{0,2}, // 1,2,3
                {1,0},{1,1},{1,2}, // 4,5,6
                {2,0},{2,1},{2,2}, // 7,8,9
                {3,0},{3,2}}; // 10,11

        StringBuilder result = new StringBuilder("");

        int left = 10; // '*'의 위치를 10
        int right = 11; // '#'의 위치를 11


        for(int n : numbers) {
            if(n == 1 || n == 4 || n == 7){
                result.append("L");
                left = n;
            } else if (n == 3 || n == 6 || n == 9){
                result.append("R");
                right = n;
            } else {
                int leftDist = Math.abs(keypad[left][0] - keypad[n][0]) + Math.abs(keypad[left][1] - keypad[n][1]);
                int rightDist = Math.abs(keypad[right][0] - keypad[n][0]) + Math.abs(keypad[right][1] - keypad[n][1]);

                if(leftDist < rightDist) {
                    result.append("L");
                    left = n;
                } else if (leftDist > rightDist) {
                    result.append("R");
                    right = n;
                } else {
                    if(hand.equals("left")){
                        result.append("L");
                        left = n;
                    } else {
                        result.append("R");
                        right = n;
                    }
                }
            }
        }
        return result.toString();
    }
}
