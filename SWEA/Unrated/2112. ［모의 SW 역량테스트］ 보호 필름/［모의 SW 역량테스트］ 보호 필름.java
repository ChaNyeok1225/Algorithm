import java.io.*;
import java.util.*;

class Solution {
	
	static int d,w,k, res;
	static int[][] board;
	static int[] set;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		
		for(int tc =1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			board = new int[d][w];
			set = new int[d];
			res = Integer.MAX_VALUE;
			Arrays.fill(set, -1);
			for(int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			
			System.out.printf("#%d %d\n",tc,res);
		}
	}
	
	static void dfs(int cnt, int idx) {
		if(cnt >= res)
			return;
		
		if(isValid()) {
			res = cnt;
			return;
		}
		
		if(idx == d)
			return;
		
		
		dfs(cnt, idx+1);
		set[idx] = 0;
		dfs(cnt+1, idx+1);
		set[idx] = 1;
		dfs(cnt+1, idx+1);
		set[idx] = -1;
		
	}
	
	static boolean isValid() {
		
		L : for(int i = 0; i < w; i++) {
			int cnt = 1;
			for(int j = 1; j < d; j++) {
				
				int v1 = board[j-1][i];
				int v2 = board[j][i];
				
				if(set[j-1] != -1)
					v1 = set[j-1];
				if(set[j] != -1)
					v2 = set[j];
				
				if(v1 == v2) {
					cnt++;
				} else
					cnt = 1;
				
				if(cnt==k)
					continue L;
			}
			return false;
		}
		
		return true;
	}
}
