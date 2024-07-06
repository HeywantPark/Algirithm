package week1;

public class PrimeNumber {
    public int solution(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k]))
                        count++;
                }
            }
        }
        return count;
    }
    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        PrimeNumber primeNumber = new PrimeNumber();
        int[] nums = {1,2,7,6,4};
        System.out.println(primeNumber.solution(nums));
    }
}
