import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, min, start[];
	static char board[][];
	static boolean vis[][][];

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];
		vis = new boolean[n][m][64];
		start = new int[2];
		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = ch[j];

				if (board[i][j] == '0') {
					start = new int[] { i, j };
					board[i][j] = '.';
				}
			}
		}

		min = Integer.MAX_VALUE;

		bfs(start[0], start[1], 0, 0);

		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	static void bfs(int x, int y, int key, int step) {

		Queue<int[]> q = new ArrayDeque<int[]>();

		vis[x][y][key] = true;
		q.offer(new int[] { x, y, key, step });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;

				if (vis[nx][ny][cur[2]])
					continue;
				
				vis[nx][ny][cur[2]] = true;
				
				if (board[nx][ny] == '.') {
					q.offer(new int[] {nx,ny, cur[2], cur[3]+1});
				} else if (Character.isUpperCase(board[nx][ny])) {

					int v = board[nx][ny] - 'A';
					if ((cur[2] & (1 << v)) != 0)
						q.offer(new int[] {nx,ny, cur[2], cur[3]+1});
				} else if (Character.isLowerCase(board[nx][ny])) {

					int v = board[nx][ny] - 'a';
					if ((cur[2] & (1 << v)) == 0) {
						vis[nx][ny][cur[2] + (1 << v)] = true;
						q.offer(new int[] {nx,ny, cur[2] + (1 << v), cur[3]+1});
					}
					else
						q.offer(new int[] {nx, ny,  cur[2], cur[3]+1});
				} else if (board[nx][ny] == '1') {
					if (min > cur[3] + 1)
						min = cur[3] + 1;
					return;
				}

			}

		}

	}

}