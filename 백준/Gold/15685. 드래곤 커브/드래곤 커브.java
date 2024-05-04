import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    boolean[][] map = new boolean[101][101];

    int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};

    for(int i = 0; i < n; i++) {
      st  = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());

      ArrayList<Integer> trace = new ArrayList<>();

      map[y][x] = true;
      x += dx[d];
      y += dy[d];
      map[y][x] = true;
      trace.add(d);
      d = (d + 1) % 4;

      for(int j = 1; j <= g; j++) {
        for(int k = trace.size() - 1; k >= 0; k--) {
          int td = (trace.get(k) + 1) % 4;

          x += dx[td];
          y += dy[td];

          map[y][x] = true;
          trace.add(td);
        }
        d = (d + 1) % 4;
      }
    }

    int answer = 0;
    for(int i = 0; i < 100; i++) {
      for(int j = 0; j < 100; j++) {
        if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1])
          answer++;
      }
    }

    System.out.println(answer);

  }

}