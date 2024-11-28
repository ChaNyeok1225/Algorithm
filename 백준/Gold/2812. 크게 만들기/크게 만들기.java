import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] number = br.readLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peekLast() < number[i] && k > 0) {
                stack.pollLast();
                k--;
            }
            stack.offer(number[i]);
        }
        

        while(k-- > 0)
            stack.pollLast();
        for(char c : stack)
            sb.append(c);

        System.out.println(sb);
    }
}