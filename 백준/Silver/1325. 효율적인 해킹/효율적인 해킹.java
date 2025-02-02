import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] edge = new ArrayList[n+1];
    BitSet[] vis = new BitSet[n+1];

    for(int i = 1; i < n + 1; i ++) {
      edge[i] = new ArrayList<>();
      vis[i] = new BitSet(n+1);
    }

    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      edge[b].add(a);
    }

    ArrayDeque<Integer> q = new ArrayDeque<>();
    int max = 0;

    for(int i = 1; i <= n; i++) {
      q.offer(i);
      vis[i].set(i);

      while(!q.isEmpty()) {
        int cur = q.poll();

        for(int next : edge[cur]) {
          if(vis[i].get(next)) continue;
          if(next < i) {
            vis[i].or(vis[next]);
          } else {
            q.offer(next);
            vis[i].set(next);
          }
        }
      }

      max = Math.max(max, vis[i].cardinality());
    }

    for(int i = 1; i <= n; i++) {
      if(vis[i].cardinality() == max)
        sb.append(i).append(" ");
    }

    System.out.println(sb);
  }

}