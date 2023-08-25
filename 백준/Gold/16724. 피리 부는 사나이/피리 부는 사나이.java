import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int[][] board = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				int num = 0;
				switch(ch[j]) {
				case 'D' :num=0;
					break; 
				case 'R' :num=1;
					break;
				case 'U' :num=2;
					break;
				case 'L' :num=3;
					break;
				}
				board[i][j] = num;
			}
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		int cnt = 0;
		int[][] vis = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(vis[i][j] > 0) continue;
				
				cnt++;
				vis[i][j] = cnt;
				q.offer(new int[] {i,j});
				
				while(!q.isEmpty()) {
					int[] p = q.poll();
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];
						
						if(nx < 0 || ny < 0 || n <= nx || m <= ny || vis[nx][ny] >0)
							continue;
						
						if(dir == board[p[0]][p[1]] || dir == (board[nx][ny] +2) % 4 ) {
							vis[nx][ny] = cnt;
							q.offer(new int[] {nx,ny});
						}
					}
				}
//				for(int x = 0; x < n; x++)
//					System.out.println(Arrays.toString(vis[x]));
//				System.out.println();
			}
		}
		System.out.println(cnt);
	}
}