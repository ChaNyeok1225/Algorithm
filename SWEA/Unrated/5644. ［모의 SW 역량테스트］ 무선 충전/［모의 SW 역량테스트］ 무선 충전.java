import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 0, -1, 0, 1, 0 }, dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int apcnt = Integer.parseInt(st.nextToken());

			int[][] move = new int[m + 1][2];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < m + 1; i++)
				move[i][0] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < m + 1; i++)
				move[i][1] = Integer.parseInt(st.nextToken());

			int[][] AP = new int[apcnt][4];

			for (int i = 0; i < apcnt; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					AP[i][j] = Integer.parseInt(st.nextToken());
			}

			int[][][] board = new int[apcnt][11][11];
			Arrays.sort(AP, (int[] a1, int[] a2) -> {
				return a2[3] - a1[3];
			});

			Queue<int[]> q = new ArrayDeque<int[]>();

//			for (int i = 0; i < apcnt; i++)
//				System.out.println(Arrays.toString(AP[i]));

			for (int i = 0; i < apcnt; i++) {

				q.offer(new int[] { AP[i][1], AP[i][0] });
				board[i][AP[i][1]][AP[i][0]] = 1;

				while (!q.isEmpty()) {
					int[] p = q.poll();

					if (board[i][p[0]][p[1]] > AP[i][2])
						continue;

					for (int dir = 1; dir < 5; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];

						if (nx < 1 || ny < 1 || 10 < nx || 10 < ny)
							continue;
						if (board[i][nx][ny] > 0)
							continue;

						board[i][nx][ny] = board[i][p[0]][p[1]] + 1;
						q.offer(new int[] { nx, ny });
					}
				}
			}

//			for (int i = 0; i < apcnt; i++) {
//				for (int j = 1; j < 11; j++)
//					System.out.println(Arrays.toString(board[i][j]));
//				System.out.println();
//			}

			int[] a = { 1, 1 };
			int[] b = { 10, 10 };

			int sec = 0, sum = 0;
			boolean[][] visap = new boolean[2][apcnt];

			while (true) {

				for (int p = 0; p < 2; p++)
					for (int i = 0; i < apcnt; i++)
						visap[p][i] = false;

				for (int i = 0; i < apcnt; i++) {
					if (board[i][a[0]][a[1]] > 0)
						visap[0][i] = true;
				}
				for (int i = 0; i < apcnt; i++) {
					if (board[i][b[0]][b[1]] > 0)
						visap[1][i] = true;
				}

				int cn = 0;
				boolean aflag = true, bflag = true;
				for (int i = 0; i < apcnt && cn < 2; i++) {
					if (visap[0][i] && visap[1][i]) {
						sum += AP[i][3];
						cn++;
					}else if ((visap[0][i] && !visap[1][i]) && aflag) {
						sum+=AP[i][3];
						aflag = false;
						cn++;
					}else if((!visap[0][i] && visap[1][i])&& bflag) {
						sum+=AP[i][3];
						bflag = false;
						cn++;
					}
				}

//				System.out.println(
//						sec + ":: a (" + a[0] + ", " + a[1] + "), b (" + b[0] + ", " + b[1] + ")" + " sum : " + sum);
//				System.out.println(Arrays.toString(visap[0]) + ", " + Arrays.toString(visap[1]));
//				System.out.println();
				sec++;

				if (sec > m)
					break;

				a[0] += dx[move[sec][0]];
				a[1] += dy[move[sec][0]];
				b[0] += dx[move[sec][1]];
				b[1] += dy[move[sec][1]];

			}
			System.out.printf("#%d %d\n", tc, sum);

		}

	}
}
