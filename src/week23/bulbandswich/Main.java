package week23.bulbandswich;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static boolean[] initial, target;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        initial = new boolean[n];
        target = new boolean[n];

        String cur = br.readLine();
        String tar = br.readLine();

        for (int i = 0; i < n; i++) {
            initial[i] = cur.charAt(i) == '1';
            target[i] = tar.charAt(i) == '1';
        }
        // 첫번째 스위치를 누르는 경우
        int press = countSwitch(initial.clone(), true);

        // 천번째 스위치를 누르지 않는 경우
        int notPress = countSwitch(initial.clone(), false);

        int answer = Math.min(press, notPress);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int countSwitch(boolean[] clone, boolean pressFirst) {

        int count = 0;

        if(pressFirst) {
            flip(clone, 0);
            count++;
        }
        for (int i = 1; i < n; i++) {
            if(clone[i - 1] != target[i - 1]) {
                flip(clone, i);
                count++;
            }
        }
        for(int i = 0; i < clone.length; i++) {
            if(clone[i] != target[i]) {
                return Integer.MAX_VALUE;
            }
        }
        return count;
    }

    private static void flip(boolean[] clone, int index) {

        clone[index] = !clone[index];
        if(index > 0) clone[index - 1] = !clone[index - 1];
        if(index < n - 1) clone[index + 1] = !clone[index + 1];

    }
}
