import java.io.*;
import java.util.*;


// 3 : 25

public class Solution {
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int tc = 1; tc < 11; tc++) {
			
			int n = Integer.parseInt(br.readLine().trim());
			
			int[][] board = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int c = 0; c < n; c++) {
				boolean state = false;
				for(int r = 0; r < n; r++) {
					if(board[r][c] == 1) {
						state = true;
					} else if(board[r][c] == 2 && state) {
						cnt++;
						state = false;
					}
				}
			}
			
			System.out.println("#"+tc+" "+cnt);
			
		}
		
	}


}