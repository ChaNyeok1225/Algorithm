import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    char[][] map = new char[8][];
    boolean[][][] vis = new boolean[2][8][8];
    for(int i = 0; i < 8; i++) {
      map[i] = br.readLine().toCharArray();
    }

    int[] dr = {0, 1,0,-1,0, 1, 1, -1, -1}, dc = {0, 0,1,0,-1,1,-1,1,-1};

    ArrayDeque<int[]> q = new ArrayDeque<>();

    if(map[7][0] == '.') {
      q.offer(new int[]{7, 0, 0});
      vis[0][7][0] = true;
    }

    int[] cur;
    int nr, nc, answer = 0;

    while(!q.isEmpty()) {
      cur = q.poll();

      if(cur[0] == 0 && cur[1] == 7) {
        answer = 1;
        break;
      }

      for(int dir = 0; dir < 9; dir++) {
        nr = cur[0] + dr[dir];
        nc = cur[1] + dc[dir];

        if(nr < 0 || nr > 7 || nc < 0 || nc > 7)
          continue;
        if(nr - cur[2] >= 0 && map[nr - cur[2]][nc] == '#')
          continue;
        if(nr - cur[2] - 1 >= 0 && map[nr - cur[2] - 1][nc] == '#')
          continue;
        if(vis[(cur[2] + 1) & 1][nr][nc])
          continue;

        q.offer(new int[] {nr, nc, cur[2] + 1});
        vis[(cur[2] + 1) & 1][nr][nc] = true;
      }
    }

    System.out.println(answer);

  }
}