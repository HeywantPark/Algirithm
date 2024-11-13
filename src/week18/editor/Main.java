package week18.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for (char c : word.toCharArray()) {
            list.add(c);
        }
        ListIterator<Character> iterator = list.listIterator(list.size());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String command = br.readLine();

            if (command.charAt(0) == 'L' && iterator.hasPrevious()) {
                iterator.previous();
            } else if (command.charAt(0) == 'D' && iterator.hasNext()) {
                iterator.next();
            } else if (command.charAt(0) == 'B' && iterator.hasPrevious()) {
                iterator.previous();
                iterator.remove();
            } else if (command.charAt(0) == 'P') {
                iterator.add(command.charAt(2));
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
