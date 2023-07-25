import java.io.*;
import java.util.*;

class pair {
	int x;
	int y;

	public pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] paints = new int[n][m];
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++)
				paints[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int num = 0;
		
		LinkedList<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int cnt = 0;
				
				if(paints[i][j] == 1) {
					num ++;
					paints[i][j] = 0;
					q.add(new int[] {i,j});
					cnt++;
				}
				
				while(!q.isEmpty()) {
					int[] xy = q.pop();
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = xy[0] + dx[dir];
						int ny = xy[1] + dy[dir];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
						if(paints[nx][ny] == 0) continue;
						
						paints[nx][ny] = 0;
						q.add(new int[] {nx,ny});
						cnt++;
					}
				}
				
				if (cnt > max)
					max = cnt;
			}
		}
		System.out.println(num);
		System.out.println(max);
		
	}

}
