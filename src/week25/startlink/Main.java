package week25.startlink;

import java.util.Scanner;

public class Main {

    static int n;
    static boolean[] visited;
    static int[][] matrix;
    static int minGroup = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // n 을 두개의 팀으로 나누기
        combination(0,0);
        System.out.println(minGroup);

    }
    private static void combination(int depth, int start) {

        if(depth == n/2) {
            calcuate();
            return;
        }
        for(int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    private static void calcuate() {

        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i] && visited[j]) {
                    startSum += matrix[i][j];
                }
                else if(!visited[i] && !visited[j]) {
                    linkSum += matrix[i][j];
                }
            }
        }
        int diff = Math.abs(startSum - linkSum);
        minGroup = Math.min(diff, minGroup);
    }
}
