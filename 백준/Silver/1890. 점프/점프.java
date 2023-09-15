import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		long[][] d = new long[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		d[0][0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == 0)
					continue;
				if(i + board[i][j] < n)
					d[i+board[i][j]][j] += d[i][j];
				if(j + board[i][j] < n)
					d[i][j + board[i][j]] += d[i][j];
			}
		}
		
		System.out.println(d[n-1][n-1]);
		
	}

}