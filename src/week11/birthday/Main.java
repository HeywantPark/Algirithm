package week11.birthday;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 학생 수 입력
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비
        List<Student> students = new ArrayList<>();

        //학생 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            sc.nextLine(); // 개행 문자 소비

            students.add(new Student(name, day, month, year));
        }
        // 나이 순으로 정렬 (가장 오래된 사람부터, 나이가 가장 많은 순서로)
        students.sort((s1, s2) -> {
            if (s1.year != s2.year) {
                return s1.year - s2.year;
            } else if (s1.month != s2.month) {
                return s1.month - s2.month;
            } else {
                return s1.day - s2.day;
            }
        });
        // 가장 나이가 적은 사람 (리스트의 마지막)
        System.out.println(students.get(N - 1).name);
        // 가장 나이가 많은 사람 (리스트의 첫 번째)
        System.out.println(students.get(0).name);

        sc.close();
    }
}
class Student {
    String name;
    int day;
    int month;
    int year;

    public Student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
