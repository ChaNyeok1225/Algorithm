import java.io.*;
import java.util.*;

//start	2023. 12. 20  14 : 52
//end 		2023. 12. 20  15 : 02
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[c+101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] cost = new int[n];
		int[] cus = new int[n];
		
		for(int i =0 ; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			cus[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1; i < c + 101; i++) {
			for(int j = 0; j < n; j++) {
				if(i < cus[j] || dp[i - cus[j]] == Integer.MAX_VALUE) continue;
				dp[i] = dp[i] < dp[i-cus[j]] + cost[j] ? dp[i] : dp[i-cus[j]] + cost[j];
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = c; i < c + 101; i++)
			ans = ans < dp[i] ? ans : dp[i];
		System.out.println(ans);

	}
}