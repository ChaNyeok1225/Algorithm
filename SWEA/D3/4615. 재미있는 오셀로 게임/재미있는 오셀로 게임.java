import java.util.*;
import java.io.*;

public class Solution {

	static int[][] board;
	static int n;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine().trim());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			board = new int[n][n];

			board[n / 2][n / 2] = 2;
			board[n / 2 - 1][n / 2] = 1;
			board[n / 2 - 1][n / 2 - 1] = 2;
			board[n / 2][n / 2 - 1] = 1;

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine().trim());

				int x = Integer.parseInt(st.nextToken()) -1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());

				setBoard(y, x, s);
				
				
			}
			
			
			
			int bcnt = 0;
			int wcnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] == 1)
						bcnt++;
					else if(board[i][j] == 2)
						wcnt++;
				}
			}
			
			
			System.out.println("#"+tc+ " " + bcnt + " " + wcnt);

		}

	}

	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 }, dy = { 0, 1, 0, -1, 1, -1, -1, 1 };

	static void setBoard(int x, int y, int s) {
		
		board[x][y] = s;
		
		
		for(int dir = 0; dir < 8; dir++) {
			int step = 1;
			while(true) {
				int nx = x + dx[dir] * step;
				int ny = y + dy[dir] * step;
				
				if(nx < 0 || ny < 0 || n <= nx || n <= ny || board[nx][ny] == 0)
					break;
				
				if(board[nx][ny] == s) {
					for(int i = 1; i < step; i++) {
						nx = x + dx[dir] * i;
						ny = y + dy[dir] * i;
						
						board[nx][ny] = s;
					}
					break;
				}
				step ++;
			}
		}
	}

}