package week25.truck;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int l = sc.nextInt();
        int[] trucks = new int[n];

        for (int i = 0; i < n; i++) {
            trucks[i] = sc.nextInt();
        }
        Queue<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) bridge.add(0); //초기 다리길이 세팅

        int time = 0;
        int weight = 0;
        int idx = 0;

        while (idx < n) {
            time++;

            weight -= bridge.poll();

            if(weight + trucks[idx] <= l) {
                bridge.add(trucks[idx]);
                weight += trucks[idx];
                idx++;
            } else {
                bridge.add(0);
            }
        }
        System.out.println(time + w);
    }
}
