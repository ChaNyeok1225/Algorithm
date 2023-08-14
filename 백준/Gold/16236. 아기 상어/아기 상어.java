import java.io.*;
import java.util.*;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		int[][] dist = new int[n][n];

		int[] sp = new int[4];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 9) {
					board[i][j] = 0;
					sp[0] = i;
					sp[1] = j;
					sp[2] = 2;
					sp[3] = 0;
				}
			}
		}

		Queue<int[]> q = new ArrayDeque<int[]>();
		int find = 0, fx = 0, fy = 0;
		int totaldist = 0;

		while (true) {

			q.clear();
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					dist[i][j] = -1;

			q.offer(sp);
			find = Integer.MAX_VALUE;
			fx = n;
			dist[sp[0]][sp[1]] = 0;

			
//			System.out.printf("***i : %d, j : %d, size : %d, least : %d ***\n", sp[0], sp[1], sp[2], sp[3]);
//			for (int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(board[i]));

			while (!q.isEmpty()) {
				int[] p = q.poll();

				if (dist[p[0]][p[1]] >= find)
					break;
					
				for (int dir = 0; dir < 4; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];

					if (nx < 0 || ny < 0 || n <= nx || n <= ny)
						continue;

					if (board[nx][ny] > sp[2] || dist[nx][ny] >= 0)
						continue;

					if (board[nx][ny] != 0 && board[nx][ny] < sp[2]) {
						find = dist[p[0]][p[1]] + 1;
						if (nx < fx) {
							fx = nx;
							fy = ny;
						}
						continue;
					}

					dist[nx][ny] = dist[p[0]][p[1]] + 1;
					q.offer(new int[] { nx, ny });

				}
			}

			if (find == Integer.MAX_VALUE)
				break;

			totaldist += find;
			board[fx][fy] = 0;

			sp[0] = fx;
			sp[1] = fy;
			sp[3]++;
			if (sp[2] == sp[3]) {
				sp[2]++;
				sp[3] = 0;
			}

		}

		System.out.println(totaldist);
	}

}
