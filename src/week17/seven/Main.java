package week17.seven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = new int[9];
        int totalSum = 0;

        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            totalSum += heights[i];
        }
        int fake1 = -1, fake2 = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (totalSum - (heights[i] + heights[j]) == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if (fake1 != -1 && fake2 != -1) {
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (i != fake1 && i != fake2) {
                result.add(heights[i]);
            }
        }
        Collections.sort(result);
        for (int r : result){
            System.out.println(r);
        }
    }
}
