package week27.twogrid;

import java.util.*;

public class Main {

    static int r, c, k;
    static int rowLen = 3, colLen = 3;
    static int[][] matrix = new int[101][101];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for(int time = 0; time <= 100; time++) {
            if(matrix[r][c] == k) {
                System.out.println(time);
                return;
            }
            if (rowLen >= colLen) {
                for (int i = 1; i <= rowLen; i++) {
                    rowCal(i);
                }
            } else {
                for (int i = 1; i <= colLen; i++) {
                    colCal(i);
                }
            }
        }
        System.out.println(-1);
    }
    private static void rowCal(int i) {

        Map<Integer, Integer> map = new HashMap<>(); // key, value
        PriorityQueue<Pair> pairs = new PriorityQueue<>();

        for (int j = 1; j <= colLen; j++) {
            if (matrix[i][j] == 0) continue;
            map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
        }
        map.forEach((k, v) -> pairs.add(new Pair(k, v)));

        int idx = 1;
        while (!pairs.isEmpty()) {
            Pair pair = pairs.poll();
            matrix[i][idx++] = pair.key;
            matrix[i][idx++] = pair.value;

        }
        colLen = Math.max(colLen, idx);

        while (idx <= 99) {
            matrix[i][idx++] = 0;
            matrix[i][idx++] = 0;
        }
    }
    private static void colCal(int i) {

        Map<Integer, Integer> map = new HashMap<>(); // key, value
        PriorityQueue<Pair> pairs = new PriorityQueue<>();

        for (int j = 1; j <= colLen; j++) {
            if (matrix[j][i] == 0) continue;
            map.put(matrix[j][i], map.getOrDefault(matrix[j][i], 0) + 1);
        }
        map.forEach((k, v) -> pairs.add(new Pair(k, v)));

        int idx = 1;
        while (!pairs.isEmpty()) {
            Pair pair = pairs.poll();
            matrix[idx++][i] = pair.key;
            matrix[idx++][i] = pair.value;

        }
        rowLen = Math.max(rowLen, idx);

        while (idx <= 99) {
            matrix[idx++][i] = 0;
            matrix[idx++][i] = 0;
        }
    }
}
class Pair implements Comparable<Pair> {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public int compareTo(Pair o){
        if (this.value != o.value){
            return Integer.compare(this.value, o.value);
        }
        return Integer.compare(this.key, o.key);
    }
}
