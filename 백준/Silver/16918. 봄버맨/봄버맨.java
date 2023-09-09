import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[r][c];
		int[][] tmp = new int[r][c];
		
		int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
		
		for(int i = 0; i < r; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				if(ch[j] == 'O') {
					board[i][j] = 3;
				}
			}
		}
		
		for(int t = 2; t <= n; t++) {
			
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(board[i][j] == 0)
						board[i][j] = t+3;
					tmp[i][j] = board[i][j];
				}
			}
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(board[i][j] == t) {
						tmp[i][j] = 0;
						
						for(int dir = 0; dir < 4; dir++) {
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							
							if(nx < 0 || ny < 0 || r <= nx || c <= ny)
								continue;
							
							tmp[nx][ny] = 0;
						}
					}
				}
			}
			
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++)
					board[i][j] = tmp[i][j];
			}
			
//			for(int i = 0; i < r; i++)
//				System.out.println(Arrays.toString(board[i]));
//			System.out.println();
			
		}
		
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(board[i][j] == 0)
					sb.append('.');
				else
					sb.append('O');
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
		
	}

}
