import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		boolean[][] vis = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++)
				board[i][j] = ch[j] - '0';
		}

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int cnt = 0;
		Queue<int[]> q = new ArrayDeque<int[]>();
		Queue<int[]> wall = new ArrayDeque<int[]>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
//				System.out.println("i : " + i + ", j : " + j);

				if (board[i][j] == 0 && !vis[i][j]) {
					cnt = 0;
					q.offer(new int[] { i, j });
					vis[i][j] = true;
				}

				while (!q.isEmpty()) {
					int[] p = q.poll();

					cnt++;

					for (int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];

						if (nx < 0 || ny < 0 || n <= nx || m <= ny || vis[nx][ny])
							continue;
						if (board[nx][ny] > 0 && !vis[nx][ny]) {
							wall.offer(new int[] { nx, ny });
							vis[nx][ny] = true;
						} else {
							q.offer(new int[] { nx, ny });
							vis[nx][ny] = true;
						}
					}

				}

				while (!wall.isEmpty()) {
					int[] p = wall.poll();
					board[p[0]][p[1]] += cnt;
					vis[p[0]][p[1]] = false;
				}

			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				sb.append(board[i][j] % 10);
			sb.append("\n");
		}

		System.out.print(sb);
	}

}
