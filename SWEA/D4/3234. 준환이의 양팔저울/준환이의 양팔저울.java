import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int ans, n, w[];
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T + 1; tc++) {
			
			n = Integer.parseInt(br.readLine());
			
			w = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n ; i++) 
				w[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(w);
			
			ans = 0;
			
			do {
				dfs(0, 0, 0);
				
			} while(np(w));
			
			System.out.printf("#%d %d\n",tc, ans);
		}
			
	}

	static void dfs(int cnt, int l, int r) {

		if(cnt == n) {
			ans++;
			return;
		}
		
		if(l + w[cnt] <= r)
			dfs(cnt+1, l + w[cnt], r);
		dfs(cnt+1, l, r+w[cnt]);
		
	}
	
	private static boolean np(int[] w) {
		int i , j, k;
		i = j = k = w.length-1;
		
		while(i > 0 && w[i-1] >= w[i])
			i--;
		
		if(i==0)
			return false;
		
		while(w[i-1] >= w[j])
			j--;
		
		int tmp = w[i-1];
		w[i-1] = w[j];
		w[j] = tmp;
		
		while(i < k) {
			tmp = w[i];
			w[i] = w[k];
			w[k] = tmp;
			i++; k--;
		}
		
		return true;
	}
}
