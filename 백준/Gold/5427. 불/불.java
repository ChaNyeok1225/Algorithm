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
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int[][] Stime = new int[r][c];
			int[][] Ftime = new int[r][c];
			for(int i = 0; i < r; i++) {
				Arrays.fill(Stime[i], 0, c, -1);
				Arrays.fill(Ftime[i], 0, c, -1);
			}
			
			
			char[][] board = new char[r][c];
			
			LinkedList<int[]> sq = new LinkedList<>();
			LinkedList<int[]> fq = new LinkedList<>();
			
			for(int i = 0; i < r; i++) {
				char[] ch = br.readLine().toCharArray();
				for(int j = 0; j < c; j++) {
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
					
					if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
					if(board[nx][ny] == '#' || Ftime[nx][ny] >= 0) continue;
					
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
					
					if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
						time = Stime[p[0]][p[1]] + 1;
						break l;
					}
					if(board[nx][ny] == '#' || Stime[nx][ny] >= 0) continue;
					if(Ftime[nx][ny] != -1 && Ftime[nx][ny] <= Stime[p[0]][p[1]] + 1)
						continue;
					
					Stime[nx][ny] = Stime[p[0]][p[1]] + 1;
					sq.add(new int[] {nx,ny});
				}
			}

			if(time == 0)
				sb.append("IMPOSSIBLE\n");
			else
				sb.append(time + "\n");
		}
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
