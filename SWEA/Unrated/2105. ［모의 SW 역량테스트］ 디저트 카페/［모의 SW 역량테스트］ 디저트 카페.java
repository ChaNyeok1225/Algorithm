import java.io.*;
import java.util.*;

// 1:55

public class Solution {

	static int[][] board;
	static boolean[] vis;
	static int[] dx = { 1, 1, -1, -1, 0 }, dy = { 1, -1, -1, 1, 0 };
	static int sx, sy, ans, n;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < T + 1; tc++) {
			n = Integer.parseInt(br.readLine().trim());
			board = new int[n][n];
			vis = new boolean[101];
			ans = -1;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					sx = i;
					sy = j;
					dfs(i, j, 0, 0);
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}

	}

	static void dfs(int x, int y, int cnt, int dir) {
		if (dir > 3)
			return;

		if (x == sx && y == sy && cnt > 1) {
			ans = ans > cnt ? ans : cnt;
			return;
		}

		if (x < 0 || y < 0 || n <= x || n <= y || vis[board[x][y]])
			return;
		
		
		vis[board[x][y]] = true;

		dfs(x + dx[dir], y + dy[dir], cnt + 1, dir);
		dfs(x + dx[dir + 1], y + dy[dir + 1], cnt + 1, dir + 1);

		vis[board[x][y]] = false;

	}

}