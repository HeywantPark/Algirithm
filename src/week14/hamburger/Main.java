package week14.hamburger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // 식탁의 길이
        int K = scanner.nextInt();  // 햄버거를 선택할 수 있는 거리
        scanner.nextLine(); // 버퍼 비우기
        String table = scanner.nextLine();  // 사람과 햄버거의 위치를 나타내는 문자열

        char[] arr = table.toCharArray();
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {  // 사람이 있는 경우
                // 사람이 햄버거를 먹을 수 있는 범위 내에서 햄버거 탐색
                for (int j = Math.max(0, i - K); j <= Math.min(N - 1, i + K); j++) {
                    if (arr[j] == 'H') {  // 햄버거가 있는 경우
                        count++;
                        arr[j] = 'X';  // 햄버거를 먹었음을 표시
                        break;
                    }
                }
            }
        }

        System.out.println(count);  // 햄버거를 먹을 수 있는 최대 사람 수 출력
    }
}
