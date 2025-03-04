package week23.yonseitoto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 과목 수
        int m = Integer.parseInt(st.nextToken()); // 마일리지

        List<Integer> minMileage = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> mileageList = new ArrayList<>();

            for (int j = 0; j < p; j++) {
                mileageList.add(Integer.parseInt(st.nextToken()));
            }
            // 최소 마일리지 찾기
            if (p < l) {
                minMileage.add(1);
            } else {
                mileageList.sort(Collections.reverseOrder()); //내림차순 정렬
                minMileage.add(mileageList.get(l - 1));
            }
        }
        // 최소 마일리지로 가능한 조합의 최대 개수 구하기
        Collections.sort(minMileage);
        int count = 0;
        for (int i = 0; i < minMileage.size(); i++) {
            if (m >= minMileage.get(i)) {
                m -= minMileage.get(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
