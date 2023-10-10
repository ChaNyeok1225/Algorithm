import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, t, board[][], tmp[][], ac[][];

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		tmp = new int[n][m];
		ac = new int[2][2];

		int idx = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == -1) {
					ac[idx][0] = i;
					ac[idx][1] = j;
					idx++;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			spread();

			air(0);
			air(1);
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(board[i][j] > 0)
					cnt += board[i][j];
			}
		}
		System.out.println(cnt);

	}

	static int rx[][] = { { -1, 0, 1, 0 }, { 1, 0, -1, 0 } }, ry[][] = { { 0, 1, 0, -1 }, { 0, 1, 0, -1 } };

	static void air(int idx) {

		int[] pos = ac[idx];

		int dir = 0;

		int a = 0;
		int b = pos[0] + 1;
		if (idx == 1) {
			a = pos[0];
			b = n;
		}

		int cx = pos[0] + rx[idx][dir];
		int cy = pos[1] + ry[idx][dir];

		int nx = cx + rx[idx][dir];
		int ny = cy + ry[idx][dir];

		while (true) {
			if(board[nx][ny] == -1) {
				board[cx][cy] = 0;
				break;
			}
			board[cx][cy] = board[nx][ny];
			cx = nx;
			cy = ny;
			nx = cx + rx[idx][dir];
			ny = cy + ry[idx][dir];

			if (limitRange(nx, ny, a, b)) {
				dir++;
				nx = cx + rx[idx][dir];
				ny = cy + ry[idx][dir];
			}
		}

	}

	static int dx[] = { 1, 0, -1, 0 }, dy[] = { 0, 1, 0, -1 };

	static void spread() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (board[i][j] > 0) {

					int value = board[i][j];
					int sv = board[i][j] / 5;

					for (int dir = 0; dir < 4; dir++) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];

						if (validIdx(nx, ny))
							continue;
						if (board[nx][ny] == -1)
							continue;
						tmp[nx][ny] += sv;
						value -= sv;
					}
					tmp[i][j] += value;
				} else if (board[i][j] == -1) {
					tmp[i][j] = board[i][j];
				}

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				board[i][j] = tmp[i][j];
			Arrays.fill(tmp[i], 0);
		}

	}

	static boolean validIdx(int x, int y) {
		return x < 0 || y < 0 || n <= x || m <= y;
	}

	static boolean limitRange(int x, int y, int a, int b) {
		return x < a || y < 0 || b <= x || m <= y;
	}

}