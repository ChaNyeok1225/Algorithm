import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static long[] arr;
  static long[] seg;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    arr = new long[n];
    seg = new long[4 * n];
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }
    init(1, 0, n - 1);

    for (int i = 0; i < m + k; i++) {
      st = new StringTokenizer(br.readLine());
      int op = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      if (op == 1) {
        update(1, 0, n - 1, a - 1, b);
      } else {
        sb.append(query(1, 0, n - 1, a - 1, b - 1)).append("\n");
      }
    }
    System.out.println(sb);
  }

  static void init(int node, int l, int r) {
    if (l == r) {
      seg[node] = arr[l];
      return;
    }

    int mid = l + (r - l) / 2;

    init(node * 2, l, mid);
    init(node * 2 + 1, mid + 1, r);

    seg[node] = seg[node * 2] + seg[node * 2 + 1];
  }

  static void update(int node, int l, int r, int index, long value) {
    if (index < l || r < index) {
      return;
    }

    if (l == r) {
      seg[node] = value;
      return;
    }

    int mid = l + (r - l) / 2;

    update(node * 2, l, mid, index, value);
    update(node * 2 + 1, mid + 1, r, index, value);

    seg[node] = seg[node * 2] + seg[node * 2 + 1];
  }

  static long query(int node, int l, int r, int s, long e) {
    if (r < s || e < l) {
      return 0;
    }

    if (s <= l && r <= e) {
      return seg[node];
    }

    int mid = l + (r - l) / 2;

    long lv = query(node * 2, l, mid, s, e);
    long rv = query(node * 2 + 1, mid + 1, r, s, e);
    return lv + rv;
  }

}