import java.io.*;
import java.util.*;

class Solution {

	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static int n, w, h, min, block;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;
			board = new int[h][w];
			block = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] > 0)
						block++;
				}
			}

			dfs(0, board, block);

			System.out.printf("#%d %d\n", tc, min);

		}
	}

	static void dfs(int cnt, int[][] board, int total) {
		if(min > total)
			min = total;
		
		
		if (cnt == n) 
			return;


		int[][] tmp = new int[h][w];

		for (int i = 0; i < w; i++) {

			for (int j = 0; j < h; j++)
				for (int k = 0; k < w; k++)
					tmp[j][k] = board[j][k];

			for (int j = 0; j < h; j++) {
				if (tmp[j][i] != 0) {
					int b = breaking(j, i, tmp);

					down(tmp);

					dfs(cnt + 1, tmp, total - b);
					break;
				}
			}
		}
	}

	private static void down(int[][] tmp) {

		for (int k = 0; k < w; k++) {
			for (int i = h - 1; i >= 0; i--) {
				if (tmp[i][k] != 0)
					continue;

				for (int j = i - 1; j >= 0; j--) {
					if (tmp[j][k] > 0) {
						tmp[i][k] = tmp[j][k];
						tmp[j][k] = 0;
						break;
					}
				}
			}
		}

	}

	private static int breaking(int x, int y, int[][] tmp) {
		int b = 1;
		int nx, ny;
		q.offer(new int[] { x, y, tmp[x][y] });
		tmp[x][y] = 0;

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				for (int step = 1; step < p[2]; step++) {
					nx = p[0] + dx[dir] * step;
					ny = p[1] + dy[dir] * step;

					if (nx < 0 || ny < 0 || h <= nx || w <= ny)
						break;

					if (tmp[nx][ny] == 0)
						continue;

					q.offer(new int[] { nx, ny, tmp[nx][ny] });
					tmp[nx][ny] = 0;
					b++;
				}
			}
		}
		
		return b;
	}

}
