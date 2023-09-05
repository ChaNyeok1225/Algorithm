import java.io.*;
import java.util.*;

public class Main {

	static int[][] board, dist;
	static boolean[][] vis;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		dist = new int[n][m];
		dist[0][0] = 1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[2]-a[2]);
		q.offer(new int[] { 0, 0, board[0][0] });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur[0] + dx[dir];
				int ny = cur[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
				if(cur[2] <= board[nx][ny])
					continue;
				
				
				if(dist[nx][ny] == 0)
					q.offer(new int[] {nx,ny, board[nx][ny]});
				dist[nx][ny] += dist[cur[0]][cur[1]];
			}
		}
		
//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(dist[i]));
		System.out.println(dist[n-1][m-1]);

	}
}