import java.io.*;
import java.util.*;

//start	2023. 12. 23  18 : 29
//end 	2023. 12. 23  
public class Main {
	
	static int n, m;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][];
		int[][] vis = new int[n][m];

		for (int i = 0; i < n; i++)
			board[i] = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;

		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
		char[] c = {'D', 'R', 'U', 'L'};
		int ans = 0;
		char ansD = ' ';
		for (int dir = 3; dir >= 0; dir--) {
			int x = sx;
			int y = sy;
			int d = (dir+3) % 4;
			int total = 0;
			
			while(true) {
				
				x += dx[d];
				y += dy[d];
				total++;
				
				if(valid(x, y) || board[x][y] == 'C')
					break;
				
				if((vis[x][y] & (1 << d)) != 0) {
					ansD = c[(dir+3) % 4];
					System.out.println(ansD);
					System.out.println("Voyager");
					return;
				}
				
				if(board[x][y] == '/') {
					vis[x][y] |= (1 << d);
					d ^= 3;
				}
				else if (board[x][y] == '\\') {
					vis[x][y] |= (1 << d);
					d ^= 1;
				}
				
				
			}
			
			if(ans < total) {
				ans = total;
				ansD = c[(dir+3) % 4];
			}
			
			for(int i = 0; i < n; i++)
				Arrays.fill(vis[i], 0);
		}
		
		System.out.println(ansD);
		System.out.println(ans);
		
	}
	
	
	static boolean valid(int x, int y) {
		return x < 0 || y < 0 || n <= x || m <= y;
	}
}