package week13.numbergame;

import java.util.Scanner;

public class Main {
    public int Solution(int n, int[][] number) {

        int maxNum = -1;
        int maxPerson = 0;

        for (int i = 0; i < n; i++) {
            int maxDigit = -1;

            for (int j = 0; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        int sum = number[i][j] + number[i][k] + number[i][l];
                        int digit = sum % 10;

                        if (digit > maxDigit) {
                            maxDigit = digit;
                        }
                    }
                }
            }
            if (maxDigit > maxNum || (maxDigit == maxNum && i + 1 > maxPerson)) {
                maxNum = maxDigit;
                maxPerson = i + 1;
            }
        }
        return maxPerson;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] number = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                number[i][j] = in.nextInt();
            }
        }
        Main main = new Main();
        System.out.println(main.Solution(n, number));
    }
}
