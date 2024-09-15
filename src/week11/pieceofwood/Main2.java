package week11.pieceofwood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        // 1. 나무판 뒷면에 쓰여진 수를 배열에 입력
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 2. 정렬이 된 경우에 불필요한 정렬 과정을 진행하지 않기 위해 정렬 체크 변수 선언
        boolean sortChk;

        // 3. bubble sort 진행
        for(int i=0; i<arr.length; i++){
            sortChk = false;

            for(int j=0; j<arr.length-1; j++){

                // 3-1. 인접한 원소를 비교하여 정렬
                if(arr[j] > arr[j+1]){
                    swap(j, j+1, arr); // 3-2. 주어진 원소의 위치를 변경
                    changeLoc(arr); // 3-3. 변경된 배열을 출력
                    sortChk = true;
                }
            }
            // 변수가 false 이면 한 라운드 내에서 한번도 원소를 교환하지 않았단 뜻으로 종료
            if(!sortChk){
                break;
            }
        }
    }

    // # 배열의 위치를 변경하는 메소드
    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // # 배열의 위치가 변경될 때 배열을 출력해주는 메소드
    private static void changeLoc(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
