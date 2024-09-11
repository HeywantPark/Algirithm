package week11.membersort;

import java.lang.reflect.Member;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 회원 수 입력 받기
        int N = scanner.nextInt();
        scanner.nextLine();

        // 회원 정보를 저장할 리스트 생성
        List<Member> members = new ArrayList<>();


        // N명의 회원 정보를 입력 받기
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ",2);
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members.add(new Member(age,name));
        }
        scanner.close();
        // 나이 순으로 정렬하되, 나이가 같으면 입력 순서를 유지
        members.sort(Comparator.comparingInt(m -> m.age));

        // 정렬된 결과 출력
        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb.toString());


    }
    // 회원 정보를 저장하는 클래스
    public static class Member{
        int age;
        String name;

        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
