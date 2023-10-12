import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static class Cell {
		int x;
		int y;
		int num;
		int dir;

		public Cell(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}

	}

	static List<Cell> cells;

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	static int n, board[][], tmp[][];

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			cells = new ArrayList<Cell>();
			board = new int[n][n];
			tmp = new int[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(board[i], -1);
				Arrays.fill(tmp[i], -1);
			}

			for (int i = 0; i < k; i++) {

				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				cells.add(new Cell(x, y, num, dir));
				board[x][y] = i;
			}

			for (int time = 0; time < m; time++) 
				move();
			
			int ans = 0;
			for(Cell c : cells) 
				ans += c.num;
			
			sb.append(String.format("#%d %d\n", tc, ans));
		}
		System.out.print(sb);

	}

	static void move() {

		Collections.sort(cells, (a, b) -> b.num - a.num);

		for (int i = 0; i < cells.size(); i++) {

			Cell cur = cells.get(i);

			int nx = cur.x + dx[cur.dir];
			int ny = cur.y + dy[cur.dir];

			if (tmp[nx][ny] != -1) {
				cells.get(tmp[nx][ny]).num += cur.num;
				cells.remove(i);
				i--;
				continue;
			}

			cur.x = nx;
			cur.y = ny;
			tmp[nx][ny] = i;
			if (nx == 0 || nx == n - 1 || ny == 0 || ny == n - 1) {
				cur.num /= 2;
				cur.dir ^= 1;
				if (cur.num == 0) {
					cells.remove(i);
					tmp[nx][ny] = -1;
					i--;
				}
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = tmp[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(tmp[i], -1);
		}

	}
}