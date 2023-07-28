import java.util.*;
import java.io.*;

public class Main {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][m];

		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = ch[j];
			}
		}
		
		int[][][] dist = new int[n][m][2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dist[i][j][0] = -1;
				dist[i][j][1] = -1;
			}
		}
		LinkedList<int[]> q = new LinkedList<>();
		q.push(new int[] {0,0,0});
		dist[0][0][0] = dist[0][0][1] = 1;
		
		while(!q.isEmpty()) {
			int[] p = q.pop();
			
			if(p[0] == n-1 && p[1] == m-1) {
				System.out.println(dist[p[0]][p[1]][p[2]]);
				break;
			}
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
				
				if(board[nx][ny] == '0' && dist[nx][ny][p[2]] == -1) {
					dist[nx][ny][p[2]] = dist[p[0]][p[1]][p[2]] + 1;
					q.add(new int[] {nx, ny, p[2]});
				}
				
				if( p[2] == 0 && board[nx][ny] == '1' && dist[nx][ny][1] == -1) {
					dist[nx][ny][1] = dist[p[0]][p[1]][p[2]] + 1;
					q.add(new int[] {nx,ny,1});
				}
			}
			
		}
		
		if(dist[n-1][m-1][1] == -1 && dist[n-1][m-1][0] == -1)
			System.out.println(-1);
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++)
//				System.out.print(dist[i][j][0] + " ");
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j++)
//				System.out.print(dist[i][j][1] + " ");
//			System.out.println();
//		}


		////////////////////////////////////////////////////
		br.close();
	}


}
