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
		int k = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		int[][][] dist = new int[k+1][n][m];

		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = ch[j] - '0';
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		dist[0][0][0] = 1;
		q.offer(new int[] { 0, 0, 0 });

		while (!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
			
				if(board[nx][ny] == 1 && p[2] < k && dist[p[2]+1][nx][ny] == 0) {
					dist[p[2]+1][nx][ny] = dist[p[2]][p[0]][p[1]] + 1;
					q.offer(new int[] {nx,ny,p[2]+1});
				} else if ( board[nx][ny] == 0 && dist[p[2]][nx][ny] == 0) {
					dist[p[2]][nx][ny] = dist[p[2]][p[0]][p[1]] + 1;
					q.offer(new int[] {nx,ny,p[2]});
				}
			}
		}
		
//		for(int i = 0; i <= k; i++) {
//			System.out.println(i + " :: ");
//			for(int j = 0; j < n; j++) {
//				for(int l = 0; l < m; l++) {
//					System.out.print(dist[i][j][l]+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println("-----");
//		}
		
		
		int res = Integer.MAX_VALUE;
		
		for(int i = 0; i <= k; i++)
			if(dist[i][n-1][m-1] != 0 && res > dist[i][n-1][m-1])
				res = dist[i][n-1][m-1];
		
		if(res == Integer.MAX_VALUE)
			res = -1;
		System.out.println(res);

	}

}
