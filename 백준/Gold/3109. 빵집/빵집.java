import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans = 0, R, C;
    static boolean flag;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][];
        for(int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++) {
            if(map[i][0] == '.') {
                flag = false;
                dfs(i, 0);
            }
        }
        System.out.println(ans);
    }

    static void dfs(int r, int c) {
        if(flag)
            return;

        map[r][c] = 'x';

        if(c == C-1) {
            ans++;
            flag = true;
            return;
        }

        if(!flag && r > 0 && map[r-1][c+1] == '.') {
            dfs(r - 1, c + 1);
        }

        if(!flag && map[r][c+1] == '.') {
            dfs(r, c + 1);
        }

        if(!flag && r < R - 1 && map[r+1][c+1] == '.') {
            dfs(r + 1, c + 1);
        }

    }
}