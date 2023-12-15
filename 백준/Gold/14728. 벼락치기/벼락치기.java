//start	2023. 12. 15  16 : 02
//end	2023. 12. 15  16 : 12
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] info = new int[n + 1][2];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][t + 1];
		for (int i = 1; i < t + 1; i++) {

			for (int j = 1; j < n + 1; j++) {
				dp[j][i] = dp[j - 1][i] > dp[j][i - 1] ? dp[j - 1][i] : dp[j][i - 1];

				if (i < info[j][0])
					continue;

				dp[j][i] = dp[j][i] > dp[j - 1][i - info[j][0]] + info[j][1] ? dp[j][i]
						: dp[j - 1][i - info[j][0]] + info[j][1];
			}
		}

		System.out.println(dp[n][t]);

	}
}