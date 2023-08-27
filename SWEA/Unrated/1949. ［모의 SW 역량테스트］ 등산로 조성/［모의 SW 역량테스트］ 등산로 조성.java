import java.io.*;
import java.util.*;

class Solution {

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int[][] board;
	static boolean[][] vis;
	static int n, k, res;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc < T+1; tc++) {
			
			st = new StringTokenizer(br.readLine());
			n =Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			board = new int[n][n];
			vis =new boolean[n][n];
			res = 0;
			int maxh = 0;
			for(int i = 0; i < n; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] > maxh)
						maxh = board[i][j];
				}
			}
			
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] == maxh) {
						vis[i][j] = true;
						dfs(i,j, 1,false);
						vis[i][j] = false;
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,res);
			
		}
	}
	
	static void dfs(int x, int y, int cnt, boolean chk) {
		
		if(cnt > res) {
			res = cnt;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || ny < 0 || n <= nx || n <= ny || vis[nx][ny])
				continue;
			
			if(board[nx][ny] < board[x][y]) {
				vis[nx][ny] = true;
				dfs(nx,ny,cnt+1,chk);
				vis[nx][ny] = false;
			} else if(board[nx][ny]-k < board[x][y] && !chk) {
				int tmp = board[nx][ny];
				board[nx][ny] = board[x][y]-1;
				vis[nx][ny] = true;
				dfs(nx,ny,cnt+1,true);
				vis[nx][ny] = false;
				board[nx][ny] = tmp;
			}
			
		}
		
	}
}
