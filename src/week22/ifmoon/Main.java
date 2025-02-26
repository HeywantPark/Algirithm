package week22.ifmoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 칭호 개수
        int m = Integer.parseInt(st.nextToken()); // 캐릭터 개수

        String[] names = new String[n];
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            sb.append(getTitle(power, names, numbers)).append("\n");
        }
        System.out.print(sb);
    }

    private static String getTitle(int power, String[] names, int[] numbers) {

        int left = 0, right = numbers.length - 1;
        int index = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] >= power) {
                index = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return names[index];
    }
}
