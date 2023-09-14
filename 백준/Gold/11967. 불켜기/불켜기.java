import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] board = new boolean[n][n];
		boolean[][] light = new boolean[n][n];
		ArrayList<int[]>[] graph = new ArrayList[n * n];

		for (int i = 0; i < n * n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;

			graph[sx * n + sy].add(new int[] { ex, ey });
		}

		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

		int ans = 1;
		light[0][0] = true;
		board[0][0] = true;

		Queue<int[]> q = new ArrayDeque<int[]>();
		Queue<int[]> tq = new ArrayDeque<int[]>();
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int[] nxt : graph[cur[0] * n + cur[1]]) {
				if (!light[nxt[0]][nxt[1]]) {
					ans++;
					light[nxt[0]][nxt[1]] = true;

					for (int dir = 0; dir < 4; dir++) {
						int nx = nxt[0] + dx[dir];
						int ny = nxt[1] + dy[dir];

						if (isVaild(nx, ny, n))
							continue;

						if (board[nx][ny]) {
							tq.offer(nxt);
							q.offer(nxt);
							board[nxt[0]][nxt[1]] = true;
							break;
						}
					}

				}
			}

			while (!tq.isEmpty()) {
				int[] lcur = tq.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nx = lcur[0] + dx[dir];
					int ny = lcur[1] + dy[dir];

					if (isVaild(nx, ny, n))
						continue;
					if (board[nx][ny] || !light[nx][ny])
						continue;

					board[nx][ny] = true;
					tq.offer(new int[] { nx, ny });
					q.offer(new int[] { nx, ny });
				}
			}

		}

		System.out.println(ans);
	}

	private static boolean isVaild(int nx, int ny, int n) {
		return nx < 0 || ny < 0 || n <= nx || n <= ny;
	}
}