import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][m];
		int[] playerMove = new int[p + 1];
		int[] getCastle = new int[p+1];
		Queue<int[]>[] playerPoint = new ArrayDeque[p + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < p + 1; i++) {
			playerMove[i] = Integer.parseInt(st.nextToken());
			playerPoint[i] = new ArrayDeque<int[]>();
		}

		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = ch[j];

				if (48 < board[i][j] && board[i][j] < 58) {
					playerPoint[board[i][j] - '0'].offer(new int[] { i, j, 0 });
					getCastle[board[i][j] - '0']++;
				}
			}
		}

		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[] endChk = new boolean[p + 1];
		int cnt = 0;
		while (true) {
			if (cnt == p)
				break;

			for (int i = 1; i < p + 1; i++) {
				if (endChk[i])
					continue;

				if (playerPoint[i].isEmpty()) {
					endChk[i] = true;
					cnt++;
					continue;
				}

				while (!playerPoint[i].isEmpty()) {
					q.offer(playerPoint[i].poll());
				}

				while (!q.isEmpty()) {
					int[] point = q.poll();

					for (int dir = 0; dir < 4; dir++) {
						int nx = point[0] + dx[dir];
						int ny = point[1] + dy[dir];

						if (nx < 0 || ny < 0 || n <= nx || m <= ny)
							continue;
						if (board[nx][ny] != '.')
							continue;

						if(board[nx][ny] == '.') {
							playerPoint[i].offer(new int[] { nx, ny, 0 });
							getCastle[i]++;
						}
							
						board[nx][ny] = board[point[0]][point[1]];
						if (point[2] < playerMove[i] - 1)
							q.offer(new int[] { nx, ny, point[2] + 1 });
						
					}

				}
//
//				for (int b = 0; b < n; b++)
//					System.out.println(Arrays.toString(board[b]));
//				System.out.println();
				
			}
		}

//		for (int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(board[i]));
		
		for(int i = 1; i < p+1; i++)
			sb.append(getCastle[i] + " ");
		System.out.println(sb);

	}
}
