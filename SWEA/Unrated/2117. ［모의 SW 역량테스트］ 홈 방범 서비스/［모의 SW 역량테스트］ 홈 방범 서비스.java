import java.io.*;
import java.util.*;

class Solution {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T= Integer.parseInt(br.readLine());
		
		for(int tc =1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[n][n];
			ArrayList<int[]> home = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if(board[i][j] == 1)
						home.add(new int[] {i,j});
				}
			}
			int max = 0;
			
			int k = 1, cost = 0,dist = 0, cnt = 0;
			while(true) {
				cost = k *k + (k-1)*(k-1);
				
				L : for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						cnt = 0;
						
						for(int idx = 0; idx < home.size(); idx++) {
							int[] p = home.get(idx);
							dist = Math.abs(i - p[0]) + Math.abs(j - p[1]);
							if(dist <= k-1)
								cnt++;
						}
						
						if(cnt*m >= cost) 
							if(max < cnt) {
								max = cnt;
						}
					}
				}
				if(home.size()*m < cost)
					break;
				k++;
			}
			System.out.printf("#%d %d\n",tc,max);
		}
		
		
	}
}
