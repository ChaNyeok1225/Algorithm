import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, k, min = Integer.MAX_VALUE;
	static int[][] home;
	static int[] run;
	static boolean[] sel;
	
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		home = new int[n][2];
		run = new int[k];
		sel = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			home[i][0] = Integer.parseInt(st.nextToken());
			home[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(min);
	}
	
	static void dfs(int idx, int cnt) {
		if(cnt == k) {
			int maxDist = 0;
			int dist = 0;
			for(int i = 0; i < n; i++) {
				if(sel[i]) continue;
				dist = Integer.MAX_VALUE;
				for(int j = 0; j < k; j++) {
					dist = Math.min(dist,Math.abs(home[run[j]][0] - home[i][0]) + Math.abs(home[run[j]][1] - home[i][1]));
				}
				
				if(maxDist < dist)
					maxDist = dist;
				
			}
			
			if(min > maxDist)
				min = maxDist;
			
			return;
		}
		
		
		for(int i = idx; i < n; i++) {
			sel[i] = true;
			run[cnt] = i;
			dfs(i+1, cnt+1);
			sel[i] = false;
		}
		
	}

}
