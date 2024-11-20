import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] map;
    static int n, max, min;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0, 0, 0, '+');
        System.out.println(max + " " + min);
    }

    static void dfs(int r, int c, int val, char op) {

        if(op == ' ') {
            if(r < n - 1)
                dfs(r + 1, c, val, map[r][c]);
            if(c < n - 1)
                dfs(r, c + 1, val, map[r][c]);
            return;
        }

        int num = map[r][c] - '0';
        switch(op) {
            case '+' :
                val += num;
                break;

            case '-' :
                val -= num;
                break;

            case '*' :
                val *= num;
                break;
        }

        if(r == n - 1 && c == n - 1) {
            max = max > val ? max : val;
            min = min < val ? min : val;
            return;
        }

        if(r < n - 1)
            dfs(r + 1, c, val, ' ');
        if(c < n - 1)
            dfs(r, c + 1, val, ' ');

    }


}