import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[][] p = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(p, (a,b) -> {
			if(a[0] == b[0]) return b[1] - a[1];
			return a[0] - b[0];
		});
		
		int[] dp = new int[p[n-1][0] + 1];
		
		int idx = 0;
		for(int i = 1; i < dp.length; i++) {
			dp[i] = dp[i-1];
			
			while(idx < p.length && p[idx][0] == i) {
				if(i - s >= 0)
					dp[i] = dp[i] > p[idx][1]+dp[i-s] ?   dp[i] : p[idx][1]+dp[i-s];
				idx++;
			}
		}
		
		System.out.println(dp[dp.length-1]);
	}
	
}