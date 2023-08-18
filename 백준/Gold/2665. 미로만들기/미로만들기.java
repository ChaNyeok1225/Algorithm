import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		char[][] board = new char[n][];

		for (int i = 0; i < n; i++)
			board[i] = br.readLine().toCharArray();

		Queue<int[]> q = new ArrayDeque<>();

		boolean[][] vis = new boolean[n][n];
		vis[0][0] = true;
		
		int[][] w = new int[n][n];
		for(int i = 0; i < n; i++)
			Arrays.fill(w[i], Integer.MAX_VALUE);
		w[0][0] = 0;
		
		
		q.offer(new int[] { 0, 0, 0 });

		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			int[] p = q.poll();

			if (p[0] == n - 1 && p[1] == n - 1) 
				continue;
			

			for (int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || n <= ny)
					continue;

				if (board[nx][ny] == '0' && w[nx][ny] > p[2] + 1) {
					q.offer(new int[] { nx, ny, p[2] + 1 });
					w[nx][ny] = p[2] + 1;
					vis[nx][ny] = true;
				} else if (board[nx][ny] == '1' && w[nx][ny] > p[2]) {
					q.offer(new int[] { nx, ny, p[2] });
					w[nx][ny] = p[2];
					vis[nx][ny] = true;
				}
			}
		}

		System.out.println(w[n-1][n-1]);
	}

}
