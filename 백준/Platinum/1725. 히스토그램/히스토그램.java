import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int[] arr, seg;
  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n + 1];
    seg = new int[n * 4];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    arr[n] = Integer.MAX_VALUE;

    init(1, 0, n - 1);

    System.out.println(solve(0, n - 1));
  }

  static void init(int node, int l, int r) {
    if (l == r) {
      seg[node] = l;
      return;
    }

    int mid = l + (r - l) / 2;

    init(node * 2, l, mid);
    init(node * 2 + 1, mid + 1, r);

    seg[node] = arr[seg[node * 2]] < arr[seg[node * 2 + 1]] ? seg[node * 2] : seg[node * 2 + 1];
  }

  static int query(int node, int l, int r, int s, int e) {
    if (e < l || r < s) {
      return n;
    }

    if (s <= l && r <= e) {
      return seg[node];
    }

    int mid = l + (r - l) / 2;
    int lv = query(node * 2, l, mid, s, e);
    int rv = query(node * 2 + 1, mid + 1, r, s, e);

    return arr[lv] < arr[rv] ? lv : rv;
  }

  static long solve(int s, int e) {
    if (s > e) {
      return 0;
    }

    int idx = query(1, 0, n - 1, s, e);
    long res = (long) arr[idx] * (e - s + 1);
//    System.out.println(s + " ~ " + e + " : " + idx);
    res = Math.max(res, solve(s, idx - 1));
    res = Math.max(res, solve(idx + 1, e));
    return res;
  }
}