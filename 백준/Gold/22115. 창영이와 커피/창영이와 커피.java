import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    final static int INF = 987_654_321;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= num[i]; j--) {
                if(dp[j - num[i]] == -1) continue;
                dp[j] = Math.min(dp[j], dp[j-num[i]] + 1);
            }
        }

        if(dp[k] == INF) dp[k] = - 1;
        System.out.println(dp[k]);


    }
}