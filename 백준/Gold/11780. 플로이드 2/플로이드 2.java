import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] cost = new int[n + 1][n + 1];
    int[][] path = new int[n + 1][n + 1];
    for(int i = 1;  i < n + 1; i++) {
      Arrays.fill(cost[i], Integer.MAX_VALUE);
      cost[i][i] = 0;
    }


    int s, e, w;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      s = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      if(cost[s][e] > w) {
        cost[s][e] = w;
        path[s][e] = e;
      }
    }


    for(int k = 1; k < n + 1; k++) {
      for(int i = 1; i < n + 1; i++) {
        for(int j = 1; j < n + 1; j++) {
          if(i == j) continue;
          if(cost[i][k] == Integer.MAX_VALUE || cost[k][j] == Integer.MAX_VALUE) continue;
          if(cost[i][j] > cost[i][k] + cost[k][j]) {
            cost[i][j] = cost[i][k] + cost[k][j];
            path[i][j] = path[i][k];
          }
        }
      }
    }

      for (int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        sb.append(cost[i][j] == Integer.MAX_VALUE ? 0 : cost[i][j]).append(" ");
      } sb.append('\n');
    }

    int cur, cnt;
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for(int i = 1; i < n + 1; i++) {
      for(int j = 1; j < n + 1; j++) {
        cur = i;
        q.offer(cur);

        while(path[cur][j] != 0) {
          cur = path[cur][j];
          q.offer(cur);
        }

        if(q.size() == 1) {
          sb.append(0);
          q.poll();
        } else {
          sb.append(q.size()).append(" ");
          while(!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
          }
        }

        sb.append("\n");
      }
    }
    System.out.print(sb);

  }
}