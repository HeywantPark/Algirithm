package week16.crosscard;

import java.util.*;

public class Main {
        // 주어진 4개의 숫자를 입력받아 가능한 회전 중 가장 작은 수를 구하는 메서드
        public static int getClockNumber(int[] numbers) {
            int minClockNumber = Integer.MAX_VALUE;

            // 시계 방향으로 회전하면서 각 4자리 수를 계산
            for (int i = 0; i < 4; i++) {
                int currentNumber = numbers[0] * 1000 + numbers[1] * 100 + numbers[2] * 10 + numbers[3];
                minClockNumber = Math.min(minClockNumber, currentNumber);
                // 배열을 회전
                int temp = numbers[0];
                for (int j = 0; j < 3; j++) {
                    numbers[j] = numbers[j + 1];
                }
                numbers[3] = temp;
            }

            return minClockNumber;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 입력받기
            int[] numbers = new int[4];
            for (int i = 0; i < 4; i++) {
                numbers[i] = sc.nextInt();
            }

            // 주어진 카드의 시계수를 구함
            int clockNumber = getClockNumber(numbers);

            // 시계수 1111부터 9999까지 중에서 몇 번째 시계수인지를 찾음
            int count = 0;
            for (int i = 1111; i <= clockNumber; i++) {
                // i가 유효한 시계수인지 확인
                int[] digits = {
                        i / 1000, (i / 100) % 10, (i / 10) % 10, i % 10
                };

                // 숫자에 0이 포함되면 시계수가 될 수 없음
                if (Arrays.stream(digits).anyMatch(digit -> digit == 0)) {
                    continue;
                }

                // i의 시계수를 계산
                int clockNumOfI = getClockNumber(digits);

                // 시계수가 i와 같으면 카운트 증가
                if (clockNumOfI == i) {
                    count++;
                }
            }

            // 결과 출력
            System.out.println(count);
        }
    }

