package week11.string;

public class Solution {
    boolean solution(String s) {
        int pcount = 0;
        int ycount = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pcount++;
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') ycount++;
        }
        return pcount == ycount;
    }
}
