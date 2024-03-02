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
      int n = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      int[] days = new int[n];
      for (int i = 0; i < n; i++) {
        days[i] = Integer.parseInt(st.nextToken());
      }

      int ans = 0;
      for (int i = 0; i < n; i++) {

        int left = i;
        int right = n - 1;

        while (left <= right) {
          int mid = left + (right - left) / 2;

          int use = (days[mid] - days[i] + 1) - (mid - i + 1);

          if (use <= p) {
            left = mid + 1;
            ans = Math.max(ans, (days[mid] - days[i] + 1) + (p - use));
          } else {
            right = mid - 1;
          }
        }

      }
      System.out.println("#" + tc + " " + ans);


    }

  }
}