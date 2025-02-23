package week22.castledepense;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int[][] grid = new int[n + 1][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // 궁수의 배치 (0 ~ m 중 3자리 선택)
        List<List<Integer>> list = new ArrayList<>();
        permutation(0,m,list,new ArrayList<>());

        int maxCount = 0;
        for (List<Integer> integers : list) {
            int count = inject(integers, grid, d, n);
            maxCount = Math.max(maxCount, count);
        }
        System.out.println(maxCount);
    }

    private static int inject(List<Integer> archers, int[][] grid, int d, int n) {
        // 그리드 복사
        int[][] test = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            test[i] = grid[i].clone();
        }
        int count = 0;
        for (int r = n; r > 0; r--) {
            List<Point> targets = new ArrayList<>();

            for (int archer : archers) {
                int targetRow = -1, targetCol = -1;
                boolean found = false;

                for (int dist = 1; dist <= d && !found; dist++) {
                    for (int delta = -dist; delta <= dist && !found; delta++) {
                        int nr = r - (dist - Math.abs(delta));
                        int nc = archer + delta;

                        if (nr < 0 || nr >= r || nc < 0 || nc >= test[0].length) continue;

                        if (test[nr][nc] == 1) {
                            targetRow = nr;
                            targetCol = nc;
                            found = true;
                        }
                    }
                }
                if (found) {
                    targets.add(new Point(targetRow, targetCol));
                }
            }
            for (Point p : targets) {
                if(test[p.x][p.y] == 1){
                    test[p.x][p.y] = 0;
                    count++;
                }
            }
        }
        return count;
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void permutation(int start,int m, List<List<Integer>> list, List<Integer> cur) {
        if(cur.size() == 3) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < m; i++) {
            cur.add(i);
            permutation(start+1,m,list,cur);
            cur.remove(cur.size()-1);
        }
    }
}
