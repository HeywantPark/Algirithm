package week23.origami;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            String paper = br.readLine();

            if(isFolding(paper,0,paper.length() -1)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isFolding(String paper, int left, int right) {

        if (left == right) return true;

        int mid = (left + right) / 2;

        for (int i = left, j = right; i < mid; i++, j--) {
            if (paper.charAt(i) == paper.charAt(j)) return false;
        }
        return isFolding(paper, left, mid - 1) && isFolding(paper, mid + 1, right);
    }
}
