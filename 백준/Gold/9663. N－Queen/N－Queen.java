import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[][] vis;

	static int cnt =0;
	
	static int[] dx = {1,1,1};
	static int[] dy = {-1,0,1};
	

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		vis = new int[n][n];
		
		func(0);

		System.out.println(cnt);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int row) {
		if (row == n) {
			cnt++;
			return;
		}else {
//			System.out.println(row);
//			for(int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(vis[i]));
//			System.out.println();
			
			
			for(int i = 0; i < n; i++) {
				if(vis[row][i] != 0) continue;
				vis[row][i] = row + 1;
				
				for(int dir = 0; dir < 3; dir++) {
					int nx = row;
					int ny = i;
					while(true) {
						nx += dx[dir];
						ny += dy[dir];
						
						if(nx < 0 || ny < 0 || n <= nx || n <= ny)
							break;
						if( vis[nx][ny] == 0)
							vis[nx][ny] = row + 1;
					}
				}
				
				func(row+1);
				
				if(vis[row][i] == row + 1)
					vis[row][i] = 0;
				for(int dir = 0; dir < 3; dir++) {
					int nx = row;
					int ny = i;
					
					while(true) {
						nx += dx[dir];
						ny += dy[dir];
						
						if(nx < 0 || ny < 0 || n <= nx || n <= ny)
							break;
						if(vis[nx][ny] == row+1)
							vis[nx][ny] = 0;
					}
				}
			}
		}
	}

}
