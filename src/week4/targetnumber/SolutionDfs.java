package week4.targetnumber;

public class SolutionDfs {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,0,target,0);
    }
    public int dfs(int[] numbers,int i, int target, int c) {
        if(i == numbers.length) {
            return (c == target) ? 1 : 0;
        }
        int sum = 0;
        sum += dfs(numbers,i + 1,target,c + numbers[i]);
        sum += dfs(numbers,i + 1,target,c - numbers[i]);
        return sum;
    }
}