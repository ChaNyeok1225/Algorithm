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
		
		char[][] board = new char[n][m];
		boolean[][] vis = new boolean[n][m];
		
		for(int i = 0; i < n; i++)
			board[i] = br.readLine().toCharArray();
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for(int i = 0; i < m; i++)
			if(board[0][i] == '0') {
				q.offer(new int[] {0,i});
				vis[0][i] = true;
			}
		
		int[] dx = { 1,0,-1,0}, dy = {0,1,0,-1};
		
		String res = "NO";
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			if(p[0] == n-1) {
				res = "YES";
				break;
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
				
				if(vis[nx][ny] || board[nx][ny] == '1')
					continue;
				
				vis[nx][ny] = true;
				q.offer(new int[] {nx,ny});
			}
		}
		
		System.out.println(res);
	

	}
	
}