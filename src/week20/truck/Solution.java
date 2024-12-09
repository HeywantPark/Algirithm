package week20.truck;

import java.util.*;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        int totalWeight = 0;
        int time = 0;
        int index = 0;

        for(int i = 0; i < bridge_length; i++){
            queue.offer(0);
        }

        while(index < truck_weights.length || totalWeight > 0){
            time++;

            int exitTruck = queue.poll();
            totalWeight -= exitTruck;

            if(index < truck_weights.length){
                if(totalWeight + truck_weights[index] <= weight) {
                    int nextTruck = truck_weights[index];
                    queue.offer(nextTruck);
                    totalWeight += nextTruck;
                    index++;
                } else {
                    queue.offer(0);
                }
            }

        }
        return time;
    }
}
