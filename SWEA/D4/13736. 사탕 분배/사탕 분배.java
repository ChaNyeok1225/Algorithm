import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      long A = Integer.parseInt(st.nextToken());
      long B = Integer.parseInt(st.nextToken());
      int round = Integer.parseInt(st.nextToken());

      long sum = A + B;

      long val = mul(2, round, sum);
      val = A * val % sum;
      System.out.println("#" + tc + " " + Math.min(val, sum - val));
    }
  }

  static long mul(long x, long p, long sum) {
    if (p == 0) {
      return 1;
    }

    long ret = mul(x, p / 2, sum);
    ret *= ret;
    if ((p & 1) == 1) {
      ret *= x;
    }

    return ret % sum;
  }

}