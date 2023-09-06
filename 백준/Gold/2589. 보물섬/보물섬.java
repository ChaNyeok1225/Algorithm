import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[n][];
		boolean[][] vis = new boolean[n][m];
		for(int i = 0; i < n; i++)
			board[i] = br.readLine().toCharArray();
		
		int max = 0;
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] == 'L') {
					q.offer(new int[] {i,j,0});
					
					for(int k = 0; k < n; k++)
						Arrays.fill(vis[k], false);
					vis[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] p = q.poll();
						
						if(max < p[2])
							max = p[2];
						
						for(int dir = 0; dir < 4; dir++) {
							int nx = p[0] + dx[dir];
							int ny = p[1] + dy[dir];
							
							if(nx < 0 || ny < 0 || n <= nx || m <= ny)
								continue;
							if(vis[nx][ny] || board[nx][ny] != 'L')
								continue;
							
							vis[nx][ny] = true;
							q.offer(new int[] {nx,ny, p[2]+1});
						}
					}
				}
			}
		}
		
		System.out.println(max);
		
		
	}

}