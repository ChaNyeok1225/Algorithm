import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    char[][] map = new char[N][M];

    boolean[][] vis = new boolean[N][M];
    ArrayDeque<int[]> q = new ArrayDeque<>();

    int sr = 0, sc = 0, building = 0, count = 0;

    for(int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
      for(int j = 0; j < M; j++) {
        if(map[i][j] == '@') {
          q.offer(new int[] {i, j});
          vis[i][j] = true;
        }
        else if(map[i][j] == '#' || map[i][j] == '*')
          building++;
      }
    }

    int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    int[] cur;
    int startFlag = 2;
    while(!q.isEmpty()) {
      cur = q.poll();

      for(int d = 0; d < 4; d++) {
        for(int step = 1; step <= startFlag; step++) {
          int nr = cur[0] + (dr[d] * step);
          int nc = cur[1] + (dc[d] * step);

          if (nr < 0 || nr >= N || nc < 0 || nc >= M || vis[nr][nc])
            continue;
          if (map[nr][nc] == '|')
            break;

          vis[nr][nc] = true;
          if (map[nr][nc] == '*') {
            q.offer(new int[]{nr, nc});
            count++;
          } else if(map[nr][nc] == '#') {
            map[nr][nc] = '*';
            vis[nr][nc] = false;
          }
        }
      }

      startFlag = 1;
    }


    System.out.println(count + " " + (building - count));

  }

}