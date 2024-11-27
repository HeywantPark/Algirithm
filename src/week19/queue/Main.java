package week19.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();

            if(s.startsWith("push")){
                int value = Integer.parseInt(s.split(" ")[1]);
                q.offer(value);
            } else if(s.equals("pop")){
                if(q.isEmpty()){
                    sb.append("-1\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
            } else if(s.equals("size")){
                sb.append(q.size()).append("\n");
            } else if(s.equals("empty")){
                sb.append(q.isEmpty() ? "1\n" : "0\n");
            } else if(s.equals("front")){
                if(q.isEmpty()){
                    sb.append("-1\n");
                } else {
                    sb.append(q.peek()).append("\n");
                }
            } else if(s.equals("back")){
                if(q.isEmpty()){
                    sb.append("-1\n");
                } else {
                    sb.append(q.peekLast()).append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}
