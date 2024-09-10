package week11.agelineup;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 회원 수 입력 받기
        int N = scanner.nextInt();
        scanner.nextLine(); // 숫자 뒤에 남아 있는 개행 문자 처리

        // 첫 줄에 N 출력
        System.out.println(N);

        // 회원 정보를 저장할 리스트 생성
        List<Member> members = new ArrayList<>();

        // N명의 회원 정보를 입력 받기
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();  // 전체 줄 입력
            String[] parts = input.split(" ", 2);  // 공백으로 나이와 이름을 분리
            int age = Integer.parseInt(parts[0]);
            String name = parts[1];
            members.add(new Member(age, name));
        }
        scanner.close();

        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return Integer.compare(m1.age, m2.age);  // 나이에 따라 오름차순 정렬
            }
        });
        // 정렬된 결과 출력
        for (Member member : members) {
            System.out.println(member);
        }
    }
    public static class Member {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
