import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		int[] dx = {1,0,-1,0,0,0};
		int[] dy = {0,1,0,-1,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[h][n][m];
		
		LinkedList<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < m; k++) {
					int num = Integer.parseInt(st.nextToken());
					box[i][j][k] = num;
					if(num == 1)
						q.add(new int[] {i,j,k});
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] p = q.pop();
			
			for(int dir = 0; dir < 6; dir++) {
				int nz = p[0] + dz[dir];
				int nx = p[1] + dx[dir];
				int ny = p[2] + dy[dir];
				
				if(nz < 0 || nx < 0 || ny < 0 || h <= nz || n <= nx || m <= ny)
					continue;
				if(box[nz][nx][ny] != 0)
					continue;
				
				box[nz][nx][ny] = box[p[0]][p[1]][p[2]] + 1;
				q.add(new int[] {nz, nx, ny});
				
			}
		}
		
//		for(int i = 0; i < h; i++) {
//			for(int[] x : box[i]) 
//				System.out.println(Arrays.toString(x));
//			System.out.println();
//		}

		int day = 0;
		l : for (int i = 0; i < h; i++) {
			for (int[] arr : box[i])
				for(int x : arr) {
					if(x == 0) {
						day = 0;
						break l;
					}
					else if(day < x)
						day = x;
				}
		}
		
		System.out.println(day-1);
		////////////////////////////////////////////////////
		br.close();
	}

}
