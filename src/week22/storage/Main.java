package week22.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new int[]{l, h});
        }
        // 리스트 정렬
        list.sort(Comparator.comparingInt(o -> o[0]));

        // 높이가 가장 큰 값 찾기
        int maxh = 0, maxStaIdx = 0, maxEndIdx = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i)[1] > maxh) {
                maxh = list.get(i)[1];
                maxStaIdx = i;
                maxEndIdx = i;
            } else if (list.get(i)[1] == maxh) {
                maxEndIdx = i;
            }
        }
        // 넓이 계산
        int area = getArea(list, maxStaIdx, maxEndIdx, maxh);
        System.out.println(area);
    }

    private static int getArea(List<int[]> list, int maxStaIdx, int maxEndIdx, int maxh) {
        int area = 0;

        // 왼쪽 -> 가장 큰 값
        int sx = list.get(0)[0];
        int sy = list.get(0)[1];

        for (int i = 1; i <= maxStaIdx; i++) {
            if(list.get(i)[1] > sy){
                int nx = list.get(i)[0];
                int ny = list.get(i)[1];
                area += Math.abs(sx - nx) * sy;
                sx = nx;
                sy = ny;
            }
        }
        // 오른쪽 -> 가장 큰 값
        int lx = list.get(list.size() -1)[0];
        int ly = list.get(list.size() -1)[1];

        for (int i = list.size() -2; i >= maxEndIdx; i--) {
            if(list.get(i)[1] > ly) {
                int nx = list.get(i)[0];
                int ny = list.get(i)[1];
                area += (lx - nx) * ly;
                lx = nx;
                ly = ny;
            }
        }
        area += (list.get(maxEndIdx)[0] - list.get(maxStaIdx)[0] + 1) * maxh;
        return area;
    }
}

