import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st; 
	
	public static void main(String[] args) throws IOException {

		
		boolean[][] board = new boolean[100][100];
		int cnt = 0;
		
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			
			for(int x = sx; x < ex; x++) {
				for(int y = sy; y < ey; y++) {
					if(!board[x][y]) {
						board[x][y] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);

	}

}
