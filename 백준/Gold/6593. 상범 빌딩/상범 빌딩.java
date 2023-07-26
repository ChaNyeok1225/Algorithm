import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] dx = { 1, 0, -1, 0, 0, 0 };
		int[] dy = { 0, 1, 0, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };

		////////////////////// 구현부/////////////////////////

		while (true) {

			st = new StringTokenizer(br.readLine());
			int z = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if(z == 0 && n == 0 && m == 0)
				break;
			
			char[][][] board = new char[z][n][m];
			int[][][] time = new int[z][n][m];
			for(int [][] ti : time)
				for(int[] t : ti)
					Arrays.fill(t, -1);

			LinkedList<int[]> q = new LinkedList<>();
			int[] ep = {0,0,0};
			for(int i = 0; i < z; i++) {
				for(int j = 0; j < n; j++) {
					char[] ch = br.readLine().toCharArray();
					for(int k = 0; k < m; k++) {
						board[i][j][k] = ch[k];
						if(ch[k] == 'S') {
							q.add(new int[] {i,j,k});
							time[i][j][k] = 0;
						}
						if(ch[k] == 'E')
							ep = new int[] {i,j,k};
					}
				}
				br.readLine();
			}
			
			
			while(!q.isEmpty()) {
				int[] p = q.pop();
				
				if(p[0] == ep[0] && p[1] == ep[1] && p[2] == ep[2])
					break;
				
				for(int dir = 0; dir < 6; dir++) {
					int nz = p[0] + dz[dir];
					int nx = p[1] + dx[dir];
					int ny = p[2] + dy[dir];
					
					if(nz < 0 || nx < 0 || ny < 0 || n <= nx || m <= ny || z <= nz)
						continue;
					if(time[nz][nx][ny] >= 0 || board[nz][nx][ny] == '#')
						continue;
				
					time[nz][nx][ny] = time[p[0]][p[1]][p[2]] + 1;
					q.add(new int[] {nz,nx,ny});
					
					
				}
				
			}
			
//			for(int[][] ti : time)
//				for(int[] t : ti)
//					System.out.println(Arrays.toString(t));
			
			if(time[ep[0]][ep[1]][ep[2]] == -1)
				sb.append("Trapped!\n");
			else
				sb.append("Escaped in " + time[ep[0]][ep[1]][ep[2]] + " minute(s).\n");
			
		}
		
		System.out.print(sb);
		////////////////////////////////////////////////////
		br.close();
	}

}
