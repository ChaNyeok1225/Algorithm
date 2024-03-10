import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] arr, maxSeg, minSeg;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new int[n];
    maxSeg = new int[n * 4];
    minSeg = new int[n * 4];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    init(1, 0, n - 1);

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken()) - 1;
      int e = Integer.parseInt(st.nextToken()) - 1;

      sb.append(queryMin(1, 0, n - 1, s, e)).append(" ").append(queryMax(1, 0, n - 1, s, e))
          .append("\n");
    }
    System.out.println(sb);
  }

  static int queryMax(int node, int l, int r, int s, int e) {
    if (e < l || r < s) {
      return Integer.MIN_VALUE;
    }

    if (s <= l && r <= e) {
      return maxSeg[node];
    }

    int mid = l + (r - l) / 2;

    int lv = queryMax(node * 2, l, mid, s, e);
    int rv = queryMax(node * 2 + 1, mid + 1, r, s, e);
    return lv > rv ? lv : rv;
  }

  static int queryMin(int node, int l, int r, int s, int e) {
    if (e < l || r < s) {
      return Integer.MAX_VALUE;
    }

    if (s <= l && r <= e) {
      return minSeg[node];
    }

    int mid = l + (r - l) / 2;

    int lv = queryMin(node * 2, l, mid, s, e);
    int rv = queryMin(node * 2 + 1, mid + 1, r, s, e);
    return lv < rv ? lv : rv;
  }

  static void init(int node, int l, int r) {
    if (l == r) {
      maxSeg[node] = arr[l];
      minSeg[node] = arr[l];
      return;
    }

    int mid = l + (r - l) / 2;

    init(node * 2, l, mid);
    init(node * 2 + 1, mid + 1, r);

    maxSeg[node] =
        maxSeg[node * 2] > maxSeg[node * 2 + 1] ? maxSeg[node * 2] : maxSeg[node * 2 + 1];
    minSeg[node] =
        minSeg[node * 2] < minSeg[node * 2 + 1] ? minSeg[node * 2] : minSeg[node * 2 + 1];
  }

}