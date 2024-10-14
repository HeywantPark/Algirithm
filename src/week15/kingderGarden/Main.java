package week15.kingderGarden;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] student = new int[n];

        for (int i = 0; i < n; i++) {
            student[i] = sc.nextInt();
        }

        List<Integer> height = new ArrayList<>();

        // 학생들의 키차이를 구해서 리스트에 저장한다.
        for (int i = 0; i < n-1; i++) {
            height.add(student[i + 1] - student[i]);
        }
        // 키차이를 오름차순 정렬한다.
        Collections.sort(height);

        // k-1개 만큼 뒤에서 부터 값을 제거한다.
        for (int i = 0; i < k-1; i++) {
            height.remove(height.size()-1);
        }
        // 나머지 값들을 더해서 계산한다.
        int count = 0;
        for (int h : height) {
            count += h;
        }
        System.out.println(count);
    }
}
