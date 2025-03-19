package week24.star;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n,m,l,k;
    static List<int[]> stars = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            stars.add(new int[]{x,y});
        }
        int maxCount = 0;
        for (int[] star1 : stars) {
            for (int[] star2 : stars) {
                int count = countStar(star1[0],star2[1]);
                maxCount = Math.max(maxCount, count);
            }
        }
        System.out.println(k - maxCount);
    }
    private static int countStar(int x, int y) {

        int nx = x + l;
        int ny = y + l;

        int count = 0;
        for(int[] star : stars) {
            int curX = star[0];
            int curY = star[1];
            if(curX >= x && curY >= y && curX <= nx && curY <= ny) {
                count++;
            }
        }
        return count;
    }
}
