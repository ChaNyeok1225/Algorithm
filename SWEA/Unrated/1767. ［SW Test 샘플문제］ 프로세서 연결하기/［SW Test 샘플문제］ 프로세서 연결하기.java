import java.io.*;
import java.util.*;

public class Solution {

	static int[][] board;
	static ArrayList<int[]> list;
	static int sumLen, conPro, n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < T + 1; tc++) {

			n = Integer.parseInt(br.readLine().trim());
			board = new int[n][n];
			list = new ArrayList<>();

			sumLen = Integer.MAX_VALUE;
			conPro = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1 && !(i == 0 || i == n - 1 || j == 0 || j == n - 1))
						list.add(new int[] { i, j });
				}
			}

			dfs(0, 0, 0, board);
			System.out.println("#"+tc+" "+sumLen);
		}

	}

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	static void dfs(int idx, int cnt, int len, int[][] board) {
		
		if (idx == list.size()) {
			
			if (cnt > conPro) {
				conPro = cnt;
				sumLen = len;
			} else if (cnt == conPro) {
				sumLen = sumLen < len ? sumLen : len;
			}
			return;
		}
		
		int[] pos = list.get(idx);
		

		dfs(idx + 1, cnt, len, board);

		int[][] copy = new int[n][n];
		
		for (int dir = 0; dir < 4; dir++) {
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					copy[i][j] = board[i][j];
			}
			
			int con = connect(pos[0], pos[1], dir, copy);
			
			if(con > 0) 
				dfs(idx+1, cnt+1, len + con, copy);
		}

	}

	private static int connect(int x, int y, int dir, int[][] board) {
		int step = 1;
		while(true) {
			int nx = x + dx[dir] * step;
			int ny = y + dy[dir] * step;
			
			if(nx < 0 || ny < 0 || n <= nx || n <= ny) {
				for(int i = 1; i < step; i++) {
					nx = x + dx[dir] * i;
					ny = y + dy[dir] * i;
					board[nx][ny] = 2;
				}
				return step - 1;
			}
			
			if(board[nx][ny] != 0)
				return 0;
			
			step++;
		}
	}

}