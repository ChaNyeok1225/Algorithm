import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    while(T-- > 0) {

      int K = Integer.parseInt(br.readLine());
      int[][] dp = new int[K][K];
      int[] sizes = new int[K];
      int[] sum = new int[K+1];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < K; i++) {
        sizes[i] = Integer.parseInt(st.nextToken());
        sum[i + 1] += sum[i] + sizes[i];
      }

      for (int i = 0; i < K; i++) {
        for (int j = 0; j + i < K; j++) {
          int s = j;
          int e = j + i;

          if (s == e) {
            dp[s][e] = 0;
          } else {
            dp[s][e] = Integer.MAX_VALUE;
            for (int k = s; k < e; k++) {
              dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k + 1][e] + sum[e+1] - sum[s] );
            }
          }
        }
      }

      sb.append(dp[0][K - 1]).append("\n");
    }

    System.out.print(sb);
  }
}