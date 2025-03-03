package week23.chocolate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        // k개 이상인 초콜릿 크기 구하기 (초콜릿의 크기가 k보다 커질때까지 2배씩 증가)
        int chocolateSize = 1;
        while (chocolateSize < k) {
            chocolateSize *= 2;
        }
        // 초콜릿을 쪼개는 최소한의 개수
        int count = 0;
        int part = chocolateSize;
        if (k != chocolateSize) {
            while (k > 0) {
                part /= 2;
                if (part <= k){
                    k -= part;
                    count++;
                } else {
                    count++;
                }
            }
        }
        System.out.println(chocolateSize + " " + count);
    }
}
