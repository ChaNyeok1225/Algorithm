//start	2023. 12. 16  18 : 52
//end	2023. 12. 16  19 : 04
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[n];
		int[] rdp = new int[n];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(num[i] > num[j])
					dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
			}
		}
		
		for(int i = n-2; i >= 0; i--) {
			for(int j = n-1; j > i; j--) {
				if(num[i] > num[j])
					rdp[i] = rdp[i] > rdp[j] + 1 ? rdp[i] : rdp[j] + 1;
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			int val = dp[i] + rdp[i];
			max = max > val ? max : val;
		}
		System.out.println(max);
		
		
	}
}