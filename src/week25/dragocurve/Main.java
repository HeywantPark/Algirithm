package week25.dragocurve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean[][] map = new boolean[101][101];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            draw(x,y,getDirections(d,g));
        }
        System.out.println(getNumberOfSquares());
    }
    public static List<Integer> getDirections(int d, int g) {

        List<Integer> dir = new ArrayList<>();
        dir.add(d);

        while (g-- > 0) {
            for(int i = dir.size() - 1; i >= 0; i--) {
                int dirX = (dir.get(i) + 1) % 4;
                dir.add(dirX);
            }
        }
        return dir;
    }
    public static void draw(int x, int y, List<Integer> dir) {

        map[x][y] = true;

        for(int d : dir){
            switch (d) {
                case 0: x += 1; break;  // 오른쪽
                case 1: y -= 1; break;  // 위쪽
                case 2: x -= 1; break;  // 왼쪽
                case 3: y += 1; break;  // 아래쪽
            }
            map[x][y] = true;  // 이동한 후 좌표를 true 처리
        }
    }
    public static int getNumberOfSquares() {

        int count = 0;
        for(int i = 0; i < map.length - 1; i++) {
            for(int j = 0; j < map[0].length -1; j++) {
                if(map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) count++;
            }
        }
        return count;
    }
}
