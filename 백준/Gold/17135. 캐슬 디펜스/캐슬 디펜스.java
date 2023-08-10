import java.util.*;
import java.io.*;

public class Main {

	static boolean[][] board, tmp, vis;
	static int[] pos;
	static int n, m, d, e, max;
	static Queue<int[]> q = new ArrayDeque<>();
	static Queue<int[]> kp = new ArrayDeque<>();

	static int[] dx = { 0, -1, 0 }, dy = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행 크기
		m = Integer.parseInt(st.nextToken()); // 열 크기
		d = Integer.parseInt(st.nextToken()); // 궁수 사거리

		// 성이 있는 곳까지 n + 1
		board = new boolean[n + 1][m];
		tmp = new boolean[n + 1][m];
		vis = new boolean[n + 1][m];
		pos = new int[3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = st.nextToken().equals("1") ? true : false;
				if (board[i][j])
					e++;
			}
		}

//		for(int i = 0; i < n+1;i++)
//			System.out.println(Arrays.toString(board[i]));

		func(0, 0);

		System.out.println(max);
		////////////////////////////////////////////////////
		br.close();

	}

	static void func(int cnt, int idx) {

		if (cnt == 3) {

			for (int i = 0; i < n + 1; i++)
				for (int j = 0; j < m; j++)
					tmp[i][j] = board[i][j];

			int total = 0, cas = 0;
			while (true) {
//				System.out.println("move********");
//				for (int i = 0; i < n + 1; i++)
//					System.out.println(Arrays.toString(tmp[i]));

				total += killEnemy();

//				System.out.println("kill********");
//				for(int i = 0; i < n+1;i++)
//				System.out.println(Arrays.toString(tmp[i]));

				moveEnemy();

				cas += endCheck();

				if(cas + total == e)
					break;
						
			}

			if (total > max)
				max = total;

//			System.out.println("end********");
//			for(int i = 0; i < n+1;i++)
//			System.out.println(Arrays.toString(tmp[i]));

			return;
		}

		for (int i = idx; i < m; i++) {
			pos[cnt] = i;
			func(cnt + 1, i + 1);
		}

	}

	private static int killEnemy() {
		int kill = 0;

		for (int arc = 0; arc < 3; arc++) {
			q.clear();

			for (int i = 0; i < n + 1; i++)
				Arrays.fill(vis[i], false);

			int x = n, y = pos[arc];

			q.offer(new int[] { x, y });

			L: while (!q.isEmpty()) {
				int[] p = q.poll();

				vis[p[0]][p[1]] = true;

				for (int dir = 0; dir < 3; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];

					if (nx < 0 || ny < 0 || n + 1 <= nx || m <= ny || vis[nx][ny])
						continue;
					if (Math.abs(nx - x) + Math.abs(ny - y) > d)
						continue;

					if (tmp[nx][ny]) {
						kp.offer(new int[] { nx, ny });
						break L;
					}

					q.offer(new int[] { nx, ny });
				}
			}
		}

		while (!kp.isEmpty()) {
			int[] p = kp.poll();

			if (tmp[p[0]][p[1]]) {
				tmp[p[0]][p[1]] = false;
				kill++;
			}
		}

		return kill;
	}

	private static void moveEnemy() {

		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (tmp[j][i]) {
					tmp[j + 1][i] = true;
					tmp[j][i] = false;
				}
			}
		}

	}

	private static int endCheck() {
		int ret = 0;
		for (int i = 0; i < m; i++)
			if (tmp[n][i]) {
				tmp[n][i] = false;
				ret++;
			}
		return ret;
	}

}
