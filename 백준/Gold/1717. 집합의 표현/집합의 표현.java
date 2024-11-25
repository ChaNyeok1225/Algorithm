import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;


    static int[] p;

    public static void main(String[] args) throws Exception {

       st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());

       p = new int[n+1];
       for(int i = 0; i < n + 1; i++)
           p[i] = i;

       int ins, op1, op2;

       for(int i = 0; i < m; i++) {
           st = new StringTokenizer(br.readLine());
           ins = Integer.parseInt(st.nextToken());
           op1 = Integer.parseInt(st.nextToken());
           op2 = Integer.parseInt(st.nextToken());

           switch(ins) {
               case 0:
                   union(op1, op2);
                   break;

               case 1:
                   sb.append(check(op1,op2) ? "YES" : "NO").append("\n");
                   break;
           }
       }

        System.out.print(sb);
    }

    static int find(int x) {
        if(x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static boolean check(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return true;
        return false;
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;
        p[a] = b;
    }


}