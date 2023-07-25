import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] Jtime = new int[r][c];
		int[][] Ftime = new int[r][c];
		for(int i = 0; i < r; i++) {
			Arrays.fill(Jtime[i], 0, c, -1);
			Arrays.fill(Ftime[i], 0, c, -1);
		}
		
		
		char[][] board = new char[r][c];
		
		LinkedList<int[]> jq = new LinkedList<>();
		LinkedList<int[]> fq = new LinkedList<>();
		
		for(int i = 0; i < r; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				board[i][j] = ch[j];
				if(ch[j] == 'J') {
					jq.add(new int[] {i,j});
					Jtime[i][j] = 0;
				}
				else if(ch[j] == 'F') {
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
		
		while(!jq.isEmpty()) {
			int[] p = jq.pop();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
					System.out.println((Jtime[p[0]][p[1]] + 1));
					return;
				}
				if(board[nx][ny] == '#' || Jtime[nx][ny] >= 0) continue;
				if(Ftime[nx][ny] != -1 && Ftime[nx][ny] <= Jtime[p[0]][p[1]] + 1)
					continue;
				
				Jtime[nx][ny] = Jtime[p[0]][p[1]] + 1;
				jq.add(new int[] {nx,ny});
			}
		}

		System.out.println("IMPOSSIBLE");
		
	}

}
