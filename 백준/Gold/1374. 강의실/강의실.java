import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int s, e;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e, map.getOrDefault(e, 0) - 1);
        }

        int answer = 0;
        int cur = 0;
        for(int v : map.values()) {
            cur += v;
            answer = answer > cur ? answer : cur;
        }
        System.out.println(answer);
    }
}