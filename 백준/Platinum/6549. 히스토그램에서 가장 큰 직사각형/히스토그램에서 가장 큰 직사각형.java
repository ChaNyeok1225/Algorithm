import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] arr, seg;
  static int n;
  static long ans;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    arr = new int[100002];
    seg = new int[400001];

    while (true) {
      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      if (n == 0) {
        break;
      }
      ans = 0;

      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }
      arr[100001] = Integer.MAX_VALUE;
      init(1, 0, n - 1);
      solve(0, n - 1);
      sb.append(ans).append("\n");
    }

    System.out.println(sb);
  }

  static void init(int node, int l, int r) {
    if (l == r) {
      seg[node] = l;
      return;
    }

    int mid = l + (r - l) / 2;
    init(node << 1, l, mid);
    init(node << 1 | 1, mid + 1, r);

    seg[node] = arr[seg[node << 1]] < arr[seg[node << 1 | 1]] ? seg[node << 1] : seg[node << 1 | 1];
  }

  static int query(int node, int l, int r, int s, int e) {
    if (e < l || r < s) {
      return 100001;
    }

    if (s <= l && r <= e) {
      return seg[node];
    }

    int mid = l + (r - l) / 2;
    int lv = query(node << 1, l, mid, s, e);
    int rv = query(node << 1 | 1, mid + 1, r, s, e);

    return arr[lv] < arr[rv] ? lv : rv;
  }

  static void solve(int s, int e) {
    if (s > e) {
      return;
    }

    int idx = query(1, 0, n - 1, s, e);
    ans = Math.max(ans, (long) arr[idx] * (e - s + 1));

    solve(s, idx - 1);
    solve(idx + 1, e);

  }

}