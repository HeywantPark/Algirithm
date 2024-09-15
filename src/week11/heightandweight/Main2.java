package week11.heightandweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력받을 사람의 수
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        // 사람들의 몸무게와 키를 저장할 리스트
        List<Person> persons = new ArrayList<>();

        // 사람들의 정보를 입력받아 리스트에 추가
        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt(); // 몸무게
            int height = sc.nextInt(); // 키
            persons.add(new Person(weight, height));
        }

        // 덩치 등수를 계산
        int[] result = calcRank(persons);

        // 결과 출력
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    // 덩치 등수를 계산하는 메서드
    private static int[] calcRank(List<Person> persons) {
        int n = persons.size(); // 사람 수
        int[] result = new int[n]; // 덩치 등수를 저장할 배열

        // 각 사람에 대해 덩치 등수 계산
        for (int i = 0; i < n; i++) {
            result[i] = 1; // 기본 등수는 1로 설정

            // 다른 사람들과 비교하여 덩치 등수를 결정
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    // 자신보다 덩치가 더 큰 사람을 찾으면 등수를 증가시킴
                    if (persons.get(i).weight < persons.get(j).weight && persons.get(i).height < persons.get(j).height) {
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }

    // 몸무게와 키를 저장하는 Person 클래스
    private static class Person {
        int weight; // 몸무게
        int height; // 키

        // Person 객체 생성자
        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}
