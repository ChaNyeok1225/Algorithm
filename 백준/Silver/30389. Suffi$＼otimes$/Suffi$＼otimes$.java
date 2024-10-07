import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        String str;
        for(int i = 0; i < n; i++) {
            str = br.readLine();
            for(int j = str.length() - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
                if(set.contains(sb.toString())) {
                    set.remove(sb.toString());
                }else {
                    set.add(sb.toString());
                }
            }
            sb.setLength(0);
        }

        System.out.println(set.size());

    }
}