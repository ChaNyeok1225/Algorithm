import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T + 1; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] board = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j = 0; j < n; j++) {
					board[i][j] = ch[j] - '0';
				}
			}
			
			int sum = 0;
			
			for(int i = 0; i <= n/2; i++) {
				for(int j = 0-i; j <= i; j++) {
					sum += board[i][(n/2) + j];
				}
				for(int j = 0-i; i != n/2 && j <= i ; j++) {
					sum += board[n-1-i][(n/2) + j];
				}
			}
			
			System.out.printf("#%d %d\n", tc, sum);
			
		}

	}
}
