import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] D = new int[10005][25];
	
	
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			int[][] ing = new int[n+1][2];
			
			for(int i = 1; i < n + 1;i++) {
				st = new StringTokenizer(br.readLine());
				ing[i][0] = Integer.parseInt(st.nextToken());
				ing[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 1; i < l + 1; i++) {
				for(int j = 1; j < n + 1; j++) {
					D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
					
					if(i >= ing[j][1]) 
						D[i][j] = Math.max(D[i][j], D[i-ing[j][1]][j-1] + ing[j][0]);
				}
			}
			
//			for(int i = 0; i < l + 1; i++)
//				System.out.println(i + " : " + Arrays.toString(D[i]));
			
			System.out.printf("#%d %d\n",tc,D[l][n]);
			
		}

	}

}
