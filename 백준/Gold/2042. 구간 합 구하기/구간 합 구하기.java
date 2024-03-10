import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static long[] seg;
  static int n;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    seg = new long[n << 1];
    for (int i = 0; i < n; i++) {
      seg[n + i] = Long.parseLong(br.readLine());
    }
    for (int i = n - 1; i > 0; i--) {
      seg[i] = seg[i * 2] + seg[i * 2 + 1];
    }

    for (int i = 0; i < m + k; i++) {
      st = new StringTokenizer(br.readLine());
      int op = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      if (op == 1) {
        update(a - 1, b);
      } else {
        sb.append(query(a - 1, (int) b - 1)).append("\n");
      }
    }
    System.out.println(sb);
  }

  static void update(int index, long value) {
    index += n;
    long diff = value - seg[index];

    while (index > 0) {
      seg[index] += diff;
      index >>>= 1;
    }
  }

  static long query(int s, int e) {
    s += n;
    e += n;

    long sum = 0;
    while (s <= e) {
      if ((s & 1) == 1) {
        sum += seg[s++];
      }
      if ((e & 1) == 0) {
        sum += seg[e--];
      }
      s >>>= 1;
      e >>>= 1;
    }
    return sum;
  }
}