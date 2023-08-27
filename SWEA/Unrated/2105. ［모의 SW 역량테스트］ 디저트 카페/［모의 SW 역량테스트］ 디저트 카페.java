import java.io.*;
import java.util.*;

class Solution {

	static int[][] board;
	static boolean[] dessert = new boolean[101];
	static int max, n;
	static int[] dx = { 1, -1, -1, 1 }, dy = { 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			board = new int[n][n];
			Arrays.fill(dessert, false);
			max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < n-1; i++)
				for (int j = 0; j < n-2; j++) {
					dessert[board[i][j]] = true;
					dfs(i, j, 0, 1, i, j);
					dessert[board[i][j]] = false;
				}
			
			if(max == 0) max = -1;
			System.out.printf("#%d %d\n",tc, max);
		}

	}

	static void dfs(int x, int y, int dir, int cnt, int sx, int sy) {
//		System.out.println(x + ", " + y);
		
		if(dir == 4)
			return;
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx == sx && ny == sy && cnt > 2) {
			if(max < cnt)
				max = cnt;
			return;
		}
		if(nx < 0 || ny < 0 || n <= nx || n <= ny)
			return;
		if(dessert[board[nx][ny]]) return;
		
		dessert[board[nx][ny]] = true;
		dfs(nx,ny, dir+1, cnt+1, sx,sy);
		dfs(nx,ny,dir,cnt+1,sx,sy);
		dessert[board[nx][ny]] = false;
	}
}
