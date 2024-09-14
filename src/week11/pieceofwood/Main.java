package week11.pieceofwood;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] pieces = new int[5];

        for (int i = 0; i < 5; i++) {
            pieces[i] = sc.nextInt();
        }
        sorted(pieces);

        sc.close();
    }
    private static void sorted(int[] pieces){
        boolean isSorted = false;

        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < pieces.length - 1; i++) {
                if (pieces[i] > pieces[i + 1]) {
                    int temp = pieces[i];
                    pieces[i] = pieces[i + 1];
                    pieces[i + 1] = temp;
                    isSorted = false;

                    for (int j = 0; j < pieces.length; j++) {
                        System.out.print(pieces[j]);
                        if (j < pieces.length - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}
