import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] board = new int[n][m];
			int[][] Ftime = new int[n][m];
			int[][] Stime = new int[n][m];
			
			for(int i = 0; i < n; i++) {
				Arrays.fill(Ftime[i],-1);
				Arrays.fill(Stime[i],-1);
			}
			
			LinkedList<int[]> fq = new LinkedList<>();
			LinkedList<int[]> sq = new LinkedList<>();
			
			for(int i = 0; i < n; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j = 0; j < m; j++) {
					board[i][j] = ch[j];
					if(ch[j] == '@') {
						sq.add(new int[] {i,j});
						Stime[i][j] = 0;
					}
					else if(ch[j] == '*') {
						fq.add(new int[] {i,j});
						Ftime[i][j] = 0;
					}
				}
			}
			
			while(!fq.isEmpty()) {
				int[] p = fq.pop();
				
				for(int dir = 0; dir < 4; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];
					
					if(nx < 0 || ny < 0 || n <= nx || m <= ny)
						continue;
					if(Ftime[nx][ny] >= 0 || board[nx][ny] == '#')
						continue;
					
					Ftime[nx][ny] = Ftime[p[0]][p[1]] + 1;
					fq.add(new int[] {nx,ny});
					
				}
			}
			
			int time = 0;
			l : while(!sq.isEmpty()) {
				int[] p = sq.pop();
				
				for(int dir = 0; dir < 4; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];
					
					if(nx < 0 || ny < 0 || n <= nx || m <= ny) {
						time = Stime[p[0]][p[1]] + 1;
						break l;
					}
					if(Stime[nx][ny] >= 0 || board[nx][ny] == '#')
						continue;
					if(Ftime[nx][ny] != -1 && Ftime[nx][ny] <= Stime[p[0]][p[1]] + 1)
						continue;
					
					Stime[nx][ny] = Stime[p[0]][p[1]] + 1;
					sq.add(new int[] {nx,ny});
					
				}
			}
			
			if (time == 0)
				sb.append("IMPOSSIBLE\n");
			else 
				sb.append(time + "\n");
		}
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
