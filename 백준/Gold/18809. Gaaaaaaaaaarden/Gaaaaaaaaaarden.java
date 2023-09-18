import java.io.*;
import java.util.*;

public class Main {

	static int n, m, R, G, max, sel1[], sel2[], board[][], chk[][][];
	static ArrayList<int[]> place = new ArrayList<>();
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		chk = new int[2][n][m];
		sel1 = new int[R + G];
		sel2 = new int[R + G];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2)
					place.add(new int[] { i, j });
			}
		}

		comb1(0, 0);

		System.out.println(max);

	}

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	static void bfs() {

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				chk[0][i][j] = 0;
				chk[1][i][j] = 0;
			}

		int flower = 0;
		
		for (int i = 0; i < R + G; i++) {
			int[] p = place.get(sel1[i]);
			q.offer(new int[] { p[0], p[1] });
			chk[0][p[0]][p[1]] = 1;
			chk[1][p[0]][p[1]] = sel2[i];
		}

		
		
		while (!q.isEmpty()) {
			
			int[] p = q.poll();
			
			if (chk[1][p[0]][p[1]] == 2)
				continue;
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
				
				
				if(chk[1][nx][ny] != 2 && (chk[0][nx][ny] == (chk[0][p[0]][p[1]] + 1)) && (chk[1][nx][ny] != chk[1][p[0]][p[1]])) {
					chk[1][nx][ny] = 2;
					flower++;
					continue;
				} else if (chk[0][nx][ny] > 0 || board[nx][ny] == 0)
					continue;
				
				chk[0][nx][ny] = chk[0][p[0]][p[1]] + 1;
				chk[1][nx][ny] = chk[1][p[0]][p[1]];
				q.offer(new int[] {nx,ny});
			}
		}
		
		if(max < flower)
			max = flower;
	}

	static void comb2(int cnt, int idx) {
		if (cnt == R) {

			bfs();
			return;
		}

		for (int i = idx; i < R + G; i++) {
			sel2[i] = 1;
			comb2(cnt + 1, i + 1);
			sel2[i] = 0;
		}
	}

	static void comb1(int cnt, int idx) {
		if (cnt == R + G) {
			comb2(0, 0);
			return;
		}

		for (int i = idx; i < place.size(); i++) {
			sel1[cnt] = i;
			comb1(cnt + 1, i + 1);
		}
	}

}