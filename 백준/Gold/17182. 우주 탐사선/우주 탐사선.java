import java.util.*;
import java.io.*;

public class Main {

  static int[][] edges;
  static int ans, n;
  static boolean[] vis;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    edges = new int[n][n];
    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        edges[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int k = 0; k < n; k++) {
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          if(edges[i][j] <= edges[i][k] + edges[k][j])
            continue;
          edges[i][j] = edges[i][k] + edges[k][j];
        }
      }
    }

    vis = new boolean[n];
    ans = Integer.MAX_VALUE;
    dfs(s,1, 0);

    if(ans == Integer.MAX_VALUE)
      ans = 0;
    System.out.println(ans);
  }

  static void dfs(int cur, int cnt, int value) {
    if(cnt == n) {
      ans = ans < value ? ans : value;
      return;
    }

    vis[cur] = true;

    for(int i = 0; i < n; i++) {
      if(vis[i]) continue;
      dfs(i, cnt + 1, value + edges[cur][i]);
    }

    vis[cur] = false;
  }
}