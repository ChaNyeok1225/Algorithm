import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		boolean[][] board = new boolean[n+1][m+1];
		boolean[][] vis = new boolean[n+1][m+1];
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y] = true;
		}
		
		int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		int max = 0, cnt = 0;
		for(int i = 1; i < n+1 ; i++) {
			for(int j = 1; j < m+1; j++) {
				if(board[i][j] && !vis[i][j]) {
					q.offer(new int[] {i,j});
					vis[i][j] = true;
					cnt = 1;
					while(!q.isEmpty()) {
						int[] p = q.poll();
						
						for(int dir = 0; dir < 4; dir++) {
							
							int nx = p[0] + dx[dir];
							int ny= p[1] + dy[dir];
							
							if(nx < 1 || ny < 1 || n < nx || m < ny)
								continue;
							
							if(vis[nx][ny] || !board[nx][ny])
								continue;
							
							cnt++;
							vis[nx][ny] = true;
							q.offer(new int[] {nx,ny});
						}
					}
					if(max < cnt)
						max = cnt;
				}
			}
		}
		
		System.out.println(max);
		
		
	}
	
}