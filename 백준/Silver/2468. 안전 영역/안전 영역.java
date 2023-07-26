import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		////////////////////// 구현부/////////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] heights = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				heights[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int rainHeight = 0;
		while(true) {
			int cnt = 0;
			boolean[][] vis = new boolean[n][n];
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					
					if(vis[i][j] == false && heights[i][j] - rainHeight > 0) {
						vis[i][j] = true;
						q.add(new int[] {i,j});
						cnt++;
					}
					
					while(!q.isEmpty()) {
						int[] p = q.pop();
						
						
						for(int dir = 0; dir < 4; dir++) {
							int nx = p[0] + dx[dir];
							int ny = p[1] + dy[dir];
							
							
							if(nx < 0 || ny < 0 || n <= nx || n <= ny)
								continue;
							if(vis[nx][ny] == true || heights[nx][ny] - rainHeight <= 0)
								continue;
							
							vis[nx][ny] = true;
							q.add(new int[] {nx,ny});
							
						}
						
					}
				}
			}
			
//			for(boolean[] v : vis)
//				System.out.println(Arrays.toString(v));
			
//			System.out.println(cnt + " " + rainHeight);
			
			if(cnt == 0)
				break;
			
			if(max < cnt)
				max = cnt;
			
			
			rainHeight++;
		}
		
		System.out.println(max);
		
		////////////////////////////////////////////////////
		br.close();
	}
	
	static void z() {
		
	}

}
