import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n + 1];
		int[] dp = new int[n+1];
		int[] dp1 = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i < n + 1; i++) {
			int range = 0;
			
			for(int j = 0;  j < n; j++) {
				if(i-j < 1 || i + j > n)
					break;
				
				if(num[i-j] == num[i+j])
					range++;
				else 
					break;
			}
			
			dp[i] = range;
		}
		for(int i = 1; i < n + 1; i++) {
			int range = 0;
			
			for(int j = 0;  j < n; j++) {
				if(i-j < 1 || i + j + 1 > n)
					break;
				
				if(num[i-j] == num[i+j+1])
					range++;
				else 
					break;
			}
			
			dp1[i] = range;
		}
		
		int range = 0;
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if((s+e) % 2 == 0) {
				range = dp[(s+e)/2];
				if(e-(s+e)/2 < range)
					sb.append(1);
				else
					sb.append(0);
				
			} else {
				range = dp1[(s+e)/2];
				if((s+e)/2 - s < range)
					sb.append(1);
				else
					sb.append(0);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
