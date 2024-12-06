import java.util.*;
import java.io.*;

public class Main {

  static class Node {
    int index;
    List<Node> prev,next;

    Node(int index) {
      this.index = index;
      prev = new ArrayList<>();
      next = new ArrayList<>();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    Node[] nodes = new Node[n + 1];
    for(int i = 1; i < n + 1; i++)
      nodes[i] = new Node(i);

    Node tmp;
    int acnt, bcnt;
    for(int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      nodes[a].next.add(nodes[b]);
      nodes[b].prev.add(nodes[a]);
    }

    ArrayDeque<Integer> q = new ArrayDeque<>();
    boolean[] visited = new boolean[n + 1];
    int cnt, cur;
    for(int i = 1; i < n + 1; i++) {

      visited[i] = true;
      q.offer(i);
      cnt = 1;

      while(!q.isEmpty()) {
        cur = q.poll();

        for(Node node : nodes[cur].next) {
          if(visited[node.index]) continue;
          visited[node.index] = true;
          q.offer(node.index);
          cnt++;
        }
      }

      q.offer(i);
      while(!q.isEmpty()) {
        cur = q.poll();
        for(Node node : nodes[cur].prev) {
          if(visited[node.index]) continue;
          visited[node.index] = true;
          q.offer(node.index);
          cnt++;
        }
      }

      Arrays.fill(visited, false);
      sb.append(n - cnt).append("\n");
    }

    System.out.print(sb);
  }

}