import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static final int SIZE = 400;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			board = new int[SIZE][SIZE];
			int cnt = 0;

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
				if (a[2] == b[2])
					return b[3] - a[3];
				return a[2] - b[2];
			});

			for (int i = SIZE / 2; i < SIZE / 2 + n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = SIZE / 2; j < SIZE / 2 + m; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

					if (board[i][j] != 0) {
						pq.offer(new int[] { i, j, board[i][j], board[i][j] });
						if (2 * board[i][j] > k)
							cnt++;
					}
				}
			}
			int sec = 0;
			while (sec <= k) {

				if (pq.peek()[2] >= sec) {
					sec++;
					continue;
				}
				int[] p = pq.poll();

				for (int dir = 0; dir < 4; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];

					if (board[nx][ny] == 0) {
						board[nx][ny] = p[3];
						pq.offer(new int[] { nx, ny, sec + p[3], p[3] });
						if (sec + p[3] * 2 > k)
							cnt++;
					}
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}