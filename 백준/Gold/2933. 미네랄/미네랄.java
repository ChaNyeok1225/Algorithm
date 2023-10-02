import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int r, c, n, ground, pos[], vis[][];
	static char board[][];
	static Queue<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine().trim());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		ground = r - 1;

		board = new char[r][];
		vis = new int[r][c];

		for (int i = 0; i < r; i++)
			board[i] = br.readLine().trim().toCharArray();

		n = Integer.parseInt(br.readLine().trim());
		pos = new int[n];

		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++)
			pos[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			int h = r - pos[i];

			int idx = shot(i, h);
			
			if (idx == -1)
				continue;

			if (sep(h, idx)) {
				int drop = searchbtw();
				
				if(drop == 0)
					continue;
				
				down(drop);
				
			}
			
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(board[i][j]);
			}sb.append("\n");
		}
		System.out.println(sb);
		
	}

	static void down(int drop) {
		
		for(int i = ground; i>=0; i--) {
			for(int j = 0; j < c ; j++) {
				if(vis[i][j] == 2)
					vis[i+drop][j] = 1;
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c ; j++) {
				if(vis[i][j] == 1)
					board[i][j] = 'x';
				else
					board[i][j] = '.';
			}
		}
		
	}
	
	static int searchbtw() {
		int v = 200, cnt = 0;

		for (int j = 0; j < c; j++) {
			cnt = 0;
			for (int i = ground; i >= 0; i--) {
				if (vis[i][j] == 1)
					cnt = 0;

				else if (vis[i][j] == 2 && v > cnt)
					v = cnt;
				else 
					cnt++;
			}
		}

		return v;
	}

	static int shot(int dir, int h) {

		if (dir % 2 == 0) {
			for (int i = 0; i < c; i++) {
				if (board[h][i] == 'x') {
					board[h][i] = '.';
					return i;
				}
			}
		} else {
			for (int i = c - 1; i >= 0; i--) {
				if (board[h][i] == 'x') {
					board[h][i] = '.';
					return i;
				}
			}
		}

		return -1;
	}

	static boolean sep(int x, int y) {
		boolean sepflag = false;

		for (int i = 0; i < r; i++)
			Arrays.fill(vis[i], 0);

		for (int i = 0; i < c; i++) {
			if (vis[ground][i] != 0 || board[ground][i] != 'x')
				continue;
			vis[ground][i] = 1;
			q.offer(new int[] { ground, i });
			while (!q.isEmpty()) {
				int[] cur = q.poll();

				search(cur[0], cur[1], 1);
			}
		}

		for (int dir = 0; dir < 4; dir++)
			search(x, y, 2);

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			search(cur[0], cur[1], 2);

			sepflag = true;
		}

		return sepflag;
	}

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	static void search(int x, int y, int fill) {

		for (int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || ny < 0 || r <= nx || c <= ny)
				continue;

			if (board[nx][ny] != 'x' || vis[nx][ny] != 0)
				continue;

			vis[nx][ny] = fill;
			q.offer(new int[] { nx, ny });
		}

	}

}