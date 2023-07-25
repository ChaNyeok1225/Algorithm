import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		int[] dx = {1,2,2,1,-1,-2,-2,-1};
		int[] dy = {2,1,-1,-2,-2,-1,1,2};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int l = Integer.parseInt(br.readLine());
			
			int[][]board = new int[l][l];
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();
			q.add(new int[] {sx , sy});
			
			while(!q.isEmpty()) {
				int[] p = q.pop();
				if(p[0] == ex && p[1] == ey)
					break;
				
				for(int dir = 0; dir < 8; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];
					
					if(nx < 0 || ny < 0 || l <= nx || l <= ny)
						continue;
					if(board[nx][ny] != 0)
						continue;
					
					board[nx][ny] = board[p[0]][p[1]] + 1;
					q.add(new int[] {nx,ny});
					
				}
				
			}
			
			
			sb.append(board[ex][ey] + "\n");
		}
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
