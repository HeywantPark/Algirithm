package week3.combinations;

import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int n, int k, List<Integer> curr, List<List<Integer>> result) {
        // basecase
        if (curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        // recursive call
        for(int i = start; i <= n; i++){
            curr.add(i);
            backtrack(i+1, n, k, curr, result);
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        int k = 3;
        List<List<Integer>> combinations = sol.combine(n, k);
        System.out.println("Combinations of " + n + " taken " + k + " at a time are:");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
