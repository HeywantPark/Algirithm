package week17.menurenewal;

import java.util.*;
import java.util.Map.Entry;

public class Solution {
    int count;
    Map<String, Integer> orderCount;
    List<String> result;

    public String[] solution(String[] orders, int[] course) {
        result = new ArrayList<>(); // 코스로 구성될 메뉴

        for (int c : course) {
            count = 0;
            orderCount = new HashMap<>(); // 주문한 메뉴 조합의 개수
            for (String order : orders) {
                combination(order,c,0,"");
            }
            if (count < 2) continue;

            for(Entry<String, Integer> set : orderCount.entrySet()) {
                if (count == set.getValue()) {
                    result.add(set.getKey());
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    public void combination(String order,int size,int idx,String sel) {
        // base part
        if (sel.length() == size) {
            String sortedWord = sort(sel);
            orderCount.put(sortedWord, orderCount.getOrDefault(sortedWord,0) +1);
            count = Math.max(count,orderCount.get(sortedWord));
            return;
        }
        // inductive part
        if (idx == order.length()) return;

        combination(order,size,idx+1,sel+order.charAt(idx)); // 다음 인덱스값을 선택하는 경우
        combination(order,size,idx+1,sel); // 다음 인덱스 값을 선택 안하는 경우

    }
    public String sort(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);

        return new String(charArray);
    }
}
