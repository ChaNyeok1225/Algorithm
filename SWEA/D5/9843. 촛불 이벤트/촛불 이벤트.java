import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      long N = Long.parseLong(br.readLine());

      long left = 0;
      long right = 3_000_000_000L;
      long ans = -1;

      while (left <= right) {
        long mid = left + (right - left) / 2;

        long val = mid * (mid + 1) / 2;

        if (val == N) {
          ans = mid;
          break;
        } else if (val < N) {
          left = mid + 1;
        } else if (val > N) {
          right = mid - 1;
        }
      }
      System.out.println("#" + tc + " " + ans);
    }

  }
}