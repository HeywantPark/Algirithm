package week1.phonebook;
import java.util.Arrays;


public class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1 ; i++) {
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean answer = solution.solution(new String[] {"ABC", "DEF", "ABCGHI", "JKL"});
        System.out.println(answer);
    }
}
