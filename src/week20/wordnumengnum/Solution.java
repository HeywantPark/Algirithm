package week20.wordnumengnum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String s) {
        Map<String, String> numberMap = new HashMap<>();

        numberMap.put("zero","0");
        numberMap.put("one","1");
        numberMap.put("two","2");
        numberMap.put("three","3");
        numberMap.put("four","4");
        numberMap.put("five","5");
        numberMap.put("six","6");
        numberMap.put("seven","7");
        numberMap.put("eight","8");
        numberMap.put("nine","9");

        for(Map.Entry<String, String> entry : numberMap.entrySet()){
            String word = entry.getKey();
            String number = entry.getValue();

            s = s.replaceAll(word,number);
        }
        return Integer.parseInt(s);
    }
}
