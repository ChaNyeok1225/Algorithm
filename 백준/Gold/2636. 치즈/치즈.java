import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static boolean[][] cheese;
	static boolean[][] air;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		cheese = new boolean[n][m];
		air = new boolean[n][m];

		int cheesecnt = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cheese[i][j] = st.nextToken().equals("1") ? true : false;
				if (cheese[i][j])
					cheesecnt++;
			}
		}
		
		q.offer(new int[] { 0, 0 });
		air[0][0] = true;

		int sec = 0, last = 0;
		while (true) {
			
			airChk();

			if (cheesecnt == 0)
				break;

			last = cheeseMelt();
			cheesecnt -= last;
			sec++;

		}

		System.out.println(sec);
		System.out.println(last);

	}

	private static int cheeseMelt() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cheese[i][j] && air[i][j]) {
					cheese[i][j] = false;
					cnt++;
					q.offer(new int[] { i, j });
				}
			}
		}
		return cnt;
	}

	static void airChk() {

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || m <= ny || air[nx][ny])
					continue;
				
				if (cheese[nx][ny] && !air[nx][ny]) {
					air[nx][ny] = true;
					continue;
				}
				
				air[nx][ny] = true;
				q.offer(new int[] { nx, ny });

			}
		}
	}

}
