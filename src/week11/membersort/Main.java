package week11.membersort;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 회원 수 입력 받기
        int N = scanner.nextInt();
        scanner.nextLine(); // 숫자 뒤에 남아 있는 개행 문자 처리

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

        // 나이 순으로 정렬하되, 나이가 같으면 입력 순서를 유지
        members.sort(Comparator.comparingInt(m -> m.age));

        // 정렬된 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(' ').append(member.name).append('\n');
        }
        System.out.print(sb.toString());
    }

    // 회원 정보를 저장하는 클래스
    public static class Member {
        int age;
        String name;

        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
