import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] map = new int[m][n];
    int[][] area = new int[m][n];

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 서, 북, 동, 남
    int[] dr = {0, -1, 0, 1}, dc = {-1, 0, 1, 0}, cur;

    HashMap<Integer, Integer> size = new HashMap<>();
    ArrayDeque<int[]> q = new ArrayDeque<>();
    int areaNum = 0, info, nr, nc, cnt, max = 0;

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(area[i][j] != 0) continue;

        area[i][j] = ++areaNum;
        cnt = 1;
        q.offer(new int[] {i, j});

        while(!q.isEmpty()) {
          cur = q.poll();
          info = map[cur[0]][cur[1]];
          for(int d = 0; d < 4; d++) {
            if((info & (1 << d)) != 0)
              continue;

            nr = cur[0] + dr[d];
            nc = cur[1] + dc[d];

            if(nr < 0 || nr >= m || nc < 0 || nc >= n)
              continue;
            if(area[nr][nc] != 0)
              continue;

            q.offer(new int[] {nr, nc});
            area[nr][nc] = areaNum;
            cnt++;
          }
        }
        max = Math.max(max, cnt);
        size.put(areaNum, cnt);
      }
    }

    int ans = 0, num;
    boolean[][] vis = new boolean[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if(vis[i][j]) continue;
        q.offer(new int[] {i, j});
        vis[i][j] = true;
        num = area[i][j];

        while(!q.isEmpty()) {
          cur = q.poll();
          for(int d = 0; d < 4; d++) {
            nr = cur[0] + dr[d];
            nc = cur[1] + dc[d];

            if(nr < 0 || nr >= m || nc < 0 || nc >= n)
              continue;
            if(vis[nr][nc])
              continue;
            if(area[nr][nc] == num) {
              q.offer(new int[]{nr, nc});
              vis[nr][nc] = true;
            } else {
              ans = Math.max(ans, size.get(num) + size.get(area[nr][nc]));
            }
          }
        }
      }
    }

    System.out.println(areaNum);
    System.out.println(max);
    System.out.println(ans);

  }
}