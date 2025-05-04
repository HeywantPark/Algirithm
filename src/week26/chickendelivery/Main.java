package week26.chickendelivery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Pos> chickenList = new ArrayList<>();
    static List<Pos> homeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] cities = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 집의 위치와 치킨집의 위치를 리스트에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(cities[i][j] == 1) {
                    homeList.add(new Pos(i, j));
                } else if (cities[i][j] == 2) {
                    chickenList.add(new Pos(i, j));
                }
            }
        }
        // 치킨집의 위치를 m개 선택하는 조합을 구한다.
        List<List<Pos>> combiList = new ArrayList<>();
        combination(m, 0, new ArrayList<>(), combiList);

        // 도시의 치킨 거리를 구한다.
        int minDist = Integer.MAX_VALUE;
        for (List<Pos> comb : combiList) {
            int dist = chickenDist(comb);
            minDist = Math.min(minDist, dist);
        }
        System.out.println(minDist);
    }

    private static int chickenDist(List<Pos> comb) {

        int sum = 0;
        for (int i = 0; i < homeList.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            int homX = homeList.get(i).x;
            int homY = homeList.get(i).y;
            for (int j = 0; j < comb.size(); j++) {
                int chicX = comb.get(j).x;
                int chicY = comb.get(j).y;
                int dist = Math.abs(homX - chicX) + Math.abs(homY - chicY);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }

    private static void combination(int m, int start, List<Pos> cur, List<List<Pos>> combiList) {

        if(cur.size() == m) {
            combiList.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < chickenList.size(); i++) {
            cur.add(chickenList.get(i));
            combination(m, i + 1, cur, combiList);
            cur.remove(cur.size() - 1);
        }
    }
}
class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
