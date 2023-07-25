import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] gr = new int[n][m];
			LinkedList<int[]> q = new LinkedList<>();
			int[] dx = {1,0,-1,0};
			int[] dy = {0,1,0,-1};
			
			
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				gr[y][x] = 1;
			}
			
			int cnt = 0;
			
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++) {
					if(gr[i][j] == 1) {
						q.add(new int[] {i,j});
						gr[i][j] = 0;
						cnt++;
					}
					
					while(!q.isEmpty()) {
						int[] p = q.pop();
						
						for(int dir = 0; dir < 4; dir++) {
							int nx = p[0] + dx[dir];
							int ny = p[1] + dy[dir];
							
							if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
							if(gr[nx][ny] == 0) continue;
							
							gr[nx][ny] = 0;
							q.add(new int[] {nx,ny});
							
						}
					}
					
				}
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

}
