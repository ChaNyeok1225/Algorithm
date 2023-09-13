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
		int T = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		int[][] dist = new int[n][m];
		
		int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		
		q.offer(new int[] {0,0});
		dist[0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			if(board[c[0]][c[1]] == 2) {
				int sd = dist[c[0]][c[1]] + Math.abs(c[0] - (n-1)) + Math.abs(c[1] - (m-1));
				if(ans > sd)
					ans = sd;
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = c[0] + dx[dir];
				int ny = c[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
				
				if(dist[nx][ny] > 0 || board[nx][ny] == 1)
					continue;
				
				dist[nx][ny] = dist[c[0]][c[1]] + 1;
				q.offer(new int[] {nx,ny});
			}
		}
		
		if(dist[n-1][m-1] != 0 && ans > dist[n-1][m-1]) {
			ans = dist[n-1][m-1];
		}
		
		if( ans-1 <= T )
			System.out.println(ans-1);
		else
			System.out.println("Fail");
		
		
	}
	


}