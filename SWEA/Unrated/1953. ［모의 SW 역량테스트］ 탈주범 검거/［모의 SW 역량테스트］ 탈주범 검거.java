import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	static int[][] path = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 1, 2 }, { 0, 1 }, { 0, 3 }, { 2, 3 } };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc < T+1; tc++) { 

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[][] board = new int[n][m];
			boolean[][] vis = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			Queue<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] { hx, hy, 1 });
			vis[hx][hy] = true;

			int posCase = 0;
			while (!q.isEmpty()) {
				int[] p = q.poll();

				if (p[2] > l)
					break;

				posCase++;

				int type = board[p[0]][p[1]];

				int nx, ny;
				for (int i = 0; i < path[type].length; i++) {
					nx = p[0] + dx[path[type][i]];
					ny = p[1] + dy[path[type][i]];

					if (nx < 0 || ny < 0 || n <= nx || m <= ny || vis[nx][ny])
						continue;

					boolean flag = false;
					switch (path[type][i]) {
					case 0:
						if (board[nx][ny] == 1 || board[nx][ny] == 2 || board[nx][ny] == 4 || board[nx][ny] == 7)
							flag = true;
						break;
					case 1:
						if (board[nx][ny] == 1 || board[nx][ny] == 3 || board[nx][ny] == 6 || board[nx][ny] == 7)
							flag = true;
						break;
					case 2:
						if (board[nx][ny] == 1 || board[nx][ny] == 2 || board[nx][ny] == 5 || board[nx][ny] == 6)
							flag = true;
						break;
					case 3:
						if (board[nx][ny] == 1 || board[nx][ny] == 3 || board[nx][ny] == 4 || board[nx][ny] == 5)
							flag = true;
						break;

					}

					if (flag) {
						q.offer(new int[] { nx, ny, p[2] + 1 });
						vis[nx][ny] = true;
					}
				}

			}

			System.out.printf("#%d %d\n", tc, posCase); // 결과 출력

		}

	}
}
