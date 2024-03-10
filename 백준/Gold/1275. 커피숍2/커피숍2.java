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
    int q = Integer.parseInt(st.nextToken());

    arr = new long[n];
    seg = new long[4 * n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Long.parseLong(st.nextToken());
    }
    init(1, 0, n - 1);

    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (x > y) {
        int tmp = x;
        x = y;
        y = tmp;
      }
      sb.append(query(1, 0, n - 1, x - 1, y - 1)).append("\n");
      update(1, 0, n - 1, a - 1, b);
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