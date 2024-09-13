package week11.birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 반의 학생 수 n을 세팅
        int n = Integer.parseInt(reader.readLine());

        // 2. 나이를 비교하기 위해 주어진 범위의 생일의 최소값과 최대값을 변수에 세팅
        int youngAge = 19900101;
        int oldAge = 20101231;

        // 3. 나이가 가장 많은 사람과 적은 사람을 출력하기 위한 변수 선언
        String old = "";
        String young = "";

        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            String[] arr = reader.readLine().split(" ");

            // 4. arr[3] : 출생연도, arr[2] : 월, arr[1] : 일
            // arr[2], arr[1] 이 1자리 일때 앞에 0을 더하고 생년월일을 8자리로 세팅한다.
            sb.append(arr[3])
                    .append(arr[2].length() == 1 ? "0" + arr[2] : arr[2])
                    .append(arr[1].length() == 1 ? "0" + arr[1] : arr[1]);
            int birth = Integer.parseInt(sb.toString());

            // 5. 나이 비교
            if(birth > youngAge) {
                // 5-1. 나이가 더 어린사람의 나이와 이름을 변수에 저장하여 최종적으로 나이가 적은 사람의 이름이 young변수에 변수에 담아져있을 겁니다.
                youngAge = birth;
                young = arr[0];
            }

            if(birth < oldAge){
                // 5-1. 나이가 더 많은사람의 나이와 이름을 변수에 저장하여 최종적으로 나이가 많은 사람의 이름이 old 변수에 담아져있을 겁니다.
                oldAge = birth;
                old = arr[0];
            }

            // 6. StringBuilder 리셋
            sb.setLength(0);
        }

        // 7. 출력
        System.out.println(young);
        System.out.println(old);
    }
}
