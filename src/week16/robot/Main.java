package week16.robot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int k = scanner.nextInt();
        int[] br = new int[k];
        int[] bc = new int[k];
        String[][] robot = new String[r][c];


        for (int i = 0; i < k; i++) {
            br[i] = scanner.nextInt();
            bc[i] = scanner.nextInt();

        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                robot[br[i]][bc[j]] = "X";
            }

        }
        int sr = scanner.nextInt();
        int sc = scanner.nextInt();

        robot[sr][sc] = "O";

        int[] nr = new int[4];
        int[] nc = new int[4];


    }
}










