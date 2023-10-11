import java.io.*;
import java.util.*;

public class Main {

	static class Shark implements Comparable<Shark> {
		int x;
		int y;
		int idx;
		int dir;

		int[][] move = new int[4][4];

		public Shark(int x, int y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", dir=" + dir + ", move=" + Arrays.toString(move[0]) + "]";
		}

		@Override
		public int compareTo(Shark o) {
			return this.idx - o.idx;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, k, board[][], tmp[][], smell[][][];

	static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
	static ArrayList<Shark> sharks = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		board = new int[n][n];
		tmp = new int[n][n];
		smell = new int[n][n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0) {
					sharks.add(new Shark(i, j, board[i][j]));
					smell[i][j][0] = board[i][j];
					smell[i][j][1] = k;
					
				}
			}
		}

		Collections.sort(sharks);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			sharks.get(i).dir = Integer.parseInt(st.nextToken()) - 1;

		for (int i = 0; i < m; i++) {
			Shark srk = sharks.get(i);

			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++)
					srk.move[j][k] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		int sec = 0;
		while (sharks.size() > 1 && sec <= 1000) {

			loop: for (int i = 0; i < sharks.size(); i++) {
				Shark srk = sharks.get(i);
				int x = srk.x;
				int y = srk.y;
				int idx = srk.idx;
				int dir = srk.dir;
				int[] mv = srk.move[dir];

				int nx = x + dx[dir];
				int ny = y + dy[dir];

				for (int d = 0; d < 4; d++) {
					nx = x + dx[mv[d]];
					ny = y + dy[mv[d]];

					if (chk(nx, ny))
						continue;

					if (smell[nx][ny][1] > sec)
						continue;
					
					if(tmp[nx][ny] != 0) {
						sharks.remove(i);
						i--;
						continue loop;
					}
					
					srk.x = nx;
					srk.y = ny;
					tmp[nx][ny] = idx;
					sharks.get(i).dir = mv[d];
					continue loop;
				}

				for (int d = 0; d < 4; d++) {
					nx = x + dx[mv[d]];
					ny = y + dy[mv[d]];

					if (chk(nx, ny))
						continue;

					if (smell[nx][ny][0] != idx)
						continue;
					
					if(tmp[nx][ny] != 0) {
						sharks.remove(i);
						i--;
						continue loop;
					}
					
					srk.x = nx;
					srk.y = ny;
					tmp[nx][ny] = idx;
					sharks.get(i).dir = mv[d];
					continue loop;
				}

			}
			
			sec++;
			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = tmp[i][j];
					if(board[i][j] > 0) {
						smell[i][j][0] = board[i][j];
						smell[i][j][1] = sec + k;
					}
				}
			}

			for (int i = 0; i < n; i++)
				Arrays.fill(tmp[i], 0);
		}
		
		if(sec > 1000)
			sec = -1;
		
		System.out.println(sec);

	}

	static boolean chk(int x, int y) {
		return x < 0 || y < 0 || n <= x || n <= y;
	}

}