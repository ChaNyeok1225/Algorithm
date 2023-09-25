import java.io.*;
import java.util.*;


public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < t + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] h = new int[n+1];
			int x = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < n+1; i++) {
				h[i] = Integer.parseInt(st.nextToken());
				x += h[i];
			}
			int[][] D = new int[n+1][x+1];
			
			int res = Integer.MAX_VALUE;
			for(int i = 1; i < n + 1; i++) {
				for(int j = 1; j < x + 1; j++) {
					D[i][j] = Math.max(D[i-1][j] , D[i][j-1]);
					
					if(j >= h[i])
						D[i][j] = Math.max(D[i][j], D[i-1][j-h[i]] + h[i]);
					
					if(D[i][j] >= b && res > D[i][j]) 
						res = D[i][j];
					
				}
			}
			
			System.out.printf("#%d %d\n",tc,res - b);
			
		}
	}
	
	
}