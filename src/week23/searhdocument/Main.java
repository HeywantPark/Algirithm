package week23.searhdocument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(char c : document.toCharArray()) {
            sb.append(c);
            if(sb.toString().contains(word)) {
                count++;
                sb.setLength(0);
            }
        }
        System.out.println(count);
    }
}
