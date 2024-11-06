import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[n][n];
        int[][] map = new int[n][n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = min < map[i][j] ? min : map[i][j];
                max = max > map[i][j] ? max : map[i][j];
            }
        }


        ArrayDeque<int[]> q = new ArrayDeque<>();
        int l = 0, r = max - min, mid, nr, nc, ans = 0;
        int[] dr = {-1,0,1,0}, dc = {0,1,0,-1}, e;
        boolean success;

        while(l <= r) {
            mid = (l + r) / 2;
            success = false;
            q.offer(new int[]{0, 0});
            visited[0][0] = true;

            while(!q.isEmpty()) {
                e = q.poll();

                if(e[0] == n - 1 && e[1] == n - 1) {
                    q.clear();
                    success = true;
                }

                for(int d = 0; d < 4; d++) {
                    nr = e[0] + dr[d];
                    nc = e[1] + dc[d];

                    if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                    if(Math.abs(map[e[0]][e[1]] - map[nr][nc]) > mid)
                        continue;
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }

            }

            if(success) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }

            for(int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
        }
        System.out.println(ans);

    }
}