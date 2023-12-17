import java.io.*;
import java.util.*;

//start	2023. 12. 17  13 : 42
//end	2023. 12. 17  14 : 22
public class Main {

	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static int[][] board;
	static int n;

	static class Data {
		double[][] map;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		double[][][] maps = new double[4][5][5];
		maps[0] = new double[][] { { 0, 0, 2, 0, 0 }, { 0, 10, 7, 1, 0 }, { 5, 0, 0, 0, 0 }, { 0, 10, 7, 1, 0 },
				{ 0, 0, 2, 0, 0 } };

		for (int i = 1; i < 4; i++)
			for (int j = 0; j < 5; j++)
				for (int k = 0; k < 5; k++)
					maps[i][j][k] = maps[i - 1][k][5 - j - 1];

		int ans = 0;
		int dir = 0;
		int dis = 1;
		int step = 0;

		int x, y;
		x = y = n / 2;
		while (true) {

			if (x == 0 && y == 0)
				break;

			x = x + dx[dir];
			y = y + dy[dir];

			int ex = board[x][y];
			board[x][y] = 0;
			int sub = 0, val = 0;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					val = (int) (ex * maps[dir][i][j] / 100);
					if (valid(x - 2 + i, y - 2 + j)) {
						ans += val;
					} else {
						board[x - 2 + i][y - 2 + j] += val;
					}
					sub += val;
				}
			}

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (valid(nx, ny)) {
				ans += ex - sub;
			} else {
				board[nx][ny] += ex - sub;
			}

			step++;
			if (step == dis) {
				dir = (dir + 1) % 4;
				step = 0;

				if (dir == 0 || dir == 2)
					dis++;
			}
		}
		System.out.println(ans);

	}

	static boolean valid(int x, int y) {
		return x < 0 || y < 0 || x >= n || y >= n;
	}
}