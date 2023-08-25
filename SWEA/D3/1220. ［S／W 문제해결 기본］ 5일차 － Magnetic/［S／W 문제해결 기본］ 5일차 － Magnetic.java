import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		for(int tc = 1; tc < 11; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] board = new int[100][100];
			
			for(int i = 0; i < n; i++) {
				st=  new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}
			
			int sum = 0;
			
			for(int i = 0; i < n ; i++) {
				boolean flag = false;
				for(int j = 0; j < n; j++) {
					if(board[j][i] == 1)
						flag = true;
					else if(board[j][i] == 2 && flag) {
						sum++;
						flag = false;
					}
				}
			}
			
			
			System.out.printf("#%d %d\n",tc,sum);
			
		}
		
	}

}
