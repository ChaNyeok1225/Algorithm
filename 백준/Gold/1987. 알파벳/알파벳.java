import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int min, r, c;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] alpha = new boolean[26];
	static char[][] board;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][];

		for (int i = 0; i < r; i++) {
			board[i] = br.readLine().toCharArray();
		}

		alpha[board[0][0]-'A'] = true;
		
		dfs(0,0,1);
		
		System.out.println(min);

	}

	static void dfs(int x, int y, int cnt) {
		if(min < cnt)
			min = cnt;
		
		
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || ny < 0 || r <= nx || c <= ny)
				continue;
			if(alpha[board[nx][ny]-'A'])
				continue;
			
			
			alpha[board[nx][ny]-'A'] = true;
			dfs(nx,ny,cnt + 1);
			alpha[board[nx][ny]-'A'] = false;
		}
		

	}

}
