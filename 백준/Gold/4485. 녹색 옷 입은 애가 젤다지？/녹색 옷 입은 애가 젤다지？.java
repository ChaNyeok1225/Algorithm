import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int cnt = 0;
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

		while (true) {
			int n = Integer.parseInt(br.readLine());
			cnt++;
			if (n == 0)
				break;

			int[][] board = new int[n][n];
			boolean[][] vis = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2]-b[2] );
			int[][] minE = new int[n][n];
			for (int i = 0; i < n; i++)
				Arrays.fill(minE[i], Integer.MAX_VALUE);

			minE[0][0] = board[0][0];
			q.offer(new int[] { 0, 0, minE[0][0] });
			while (!q.isEmpty()) {
				int[] c = q.poll();
				
				if(c[0] == n-1 && c[1] == n-1)
					break;
				
				if(vis[c[0]][c[1]])
					continue;
				
				vis[c[0]][c[1]] = true;
				
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = c[0] + dx[dir];
					int ny = c[1] + dy[dir];
					
					if(nx < 0 || ny < 0 || n <= nx || n <= ny)
						continue;
					
					if(!vis[nx][ny] && minE[nx][ny] > c[2] + board[nx][ny]) {
						minE[nx][ny] = c[2] + board[nx][ny];
						q.offer(new int[] {nx,ny,minE[nx][ny]});
					}
				}
			}

			sb.append(String.format("Problem %d: %d\n", cnt, minE[n-1][n-1]));
		}

		System.out.println(sb);
	}

}