package week20.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> time = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            time.add(sc.nextInt());
        }
        // 시간이 빠른 순으로 정렬
        Collections.sort(time);

        // 최소시간 계산
        int minTime = 0;
        int index = 0;

        while (index < time.size()) {
            for (int i = 0; i <= index; i++) {
                minTime += time.get(i);
            }
            index++;
        }
        System.out.println(minTime);
    }
}
