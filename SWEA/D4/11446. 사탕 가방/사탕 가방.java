import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      long M = Long.parseLong(st.nextToken());

      long[] candy = new long[N];

      st = new StringTokenizer(br.readLine());
      long max = 0;
      for (int i = 0; i < N; i++) {
        candy[i] = Long.parseLong(st.nextToken());
        max = max > candy[i] ? max : candy[i];
      }
      long ans = 0;
      long left = 1;
      long right = max;

      while (left <= right) {
        long mid = left + (right - left) / 2;

        long cnt = 0;

        for (int i = 0; i < N; i++) {
          cnt += candy[i] / mid;
        }

        if (cnt >= M) {
          left = mid + 1;
          ans = mid;
        } else {
          right = mid - 1;
        }
      }

      System.out.println("#" + tc + " " + ans);
    }

  }
}