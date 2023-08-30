import java.util.*;
import java.io.*;

public class Main {

	static int n, min, start, cost[][];
	static boolean vis[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		cost = new int[n][n];
		vis = new boolean[n];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < n; i++) {
			vis[i] = true;
			start = i;
			dfs(i, 1, 0);
			vis[i] = false;
		}
		
		System.out.println(min);
	}
	
	static void dfs(int idx, int cnt, int totalcost) {
		if(cnt == n) {
			if(cost[idx][start] > 0) {
				totalcost += cost[idx][start];
				if(min > totalcost)
					min = totalcost;
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(vis[i]) continue;
			
			if(cost[idx][i] > 0) {
				vis[i] = true;
				dfs(i, cnt+1, totalcost + cost[idx][i]);
				vis[i] = false;
			}
		}
	}
	
}
