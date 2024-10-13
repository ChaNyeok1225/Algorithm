import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n+2][m+2];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
            }
        }

        int[] dr = {1, 0, -1, 0, -1, 1}, dc[] = {{0, 1, 0, -1, -1, -1}, {0,1,0,-1,1,1}}; 

        boolean[][] vis = new boolean[n+2][m+2];

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0});
        vis[0][0] = true;

        int[] cur;
        int nr, nc;
        int answer = 0;
        while(!q.isEmpty()) {
            cur = q.poll();

            for(int dir = 0; dir < 6; dir++) {
                nr = cur[0] + dr[dir];
                nc = cur[1] + dc[cur[0] & 1][dir];

                if(nr < 0 || nr > n + 1 || nc < 0 || nc > m + 1) {
                    continue;
                }

                if(vis[nr][nc]) {
                    continue;
                }

                if(map[nr][nc]) {
                    answer++;
                    continue;
                }

                q.offer(new int[] {nr, nc});
                vis[nr][nc] = true;

            }

        }

        System.out.println(answer);

    }
}