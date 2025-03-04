package week23.walk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken()); // 한 블록 가는데 걸리는 시간
        int s = Integer.parseInt(st.nextToken()); // 대각선으로 가는데 걸리는 시간

        long time = 0;

        // 직선 이동만 하는 경우
        long case1 = (long) (x + y) * w;

        // 직선 + 대각선 이동하는 경우
        long case2 = (long) Math.min(x, y) * s + (long) (Math.abs(x - y)) * w;

        // 대각선 이동만 하는 경우 (둘다 짝수 혹은 둘다 홀수)
        long case3 = (long) Math.max(x, y) * s;
        if ((x + y) % 2 != 0){
            case3 -= s;
            case3 += w;
        }
        time = Math.min(case1, Math.min(case2, case3));
        System.out.println(time);
    }
}
