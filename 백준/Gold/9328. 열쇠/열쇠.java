import java.io.*;
import java.util.*;

public class Main {

	static int n, m, docu;
	static ArrayList<int[]>[] door = new ArrayList[26];
	static char[][] board;
	static boolean[] key, vis[];
	static Queue<int[]> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			docu = 0;
			// 각 문의 위치를 담는 ArrayList

			for (int i = 0; i < 26; i++)
				door[i] = new ArrayList<>();

			// board 입력
			board = new char[n][m];
			vis = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					board[i][j] = c[j];

					// 대문자 알파벳이면 좌표 저장
					if (Character.isUpperCase(board[i][j]))
						door[board[i][j] - 'A'].add(new int[] { i, j });
				}
			}

			// 현재 가진 열쇠를 담을 배열
			key = new boolean[26];

			char[] c = br.readLine().toCharArray();
			if (c[0] != '0') {
				for (int i = 0; i < c.length; i++)
					key[c[i] - 'a'] = true;
			}

			q = new ArrayDeque<int[]>();

			// 가장자리 탐색
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					
					if ((i != 0 && i != n - 1) && (j != 0 && j != m - 1))
						continue;

					vis[i][j] = true;
					int state = chkBoard(i, j);
					switch (state) {

					case 0:
						break;

					case 1:
						q.offer(new int[] { i, j });
						break;

					case 2:
						q.offer(new int[] { i, j });
						key[board[i][j] - 'a'] = true;
						open(board[i][j] - 'a');

						break;

					case 3:
						if (key[board[i][j] - 'A'])
							q.offer(new int[] { i, j });
						break;

					case 4:
						docu++;
						q.offer(new int[] { i, j });
						break;
					}
				}
			}

			int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				
//				System.out.println(Arrays.toString(cur));

				for (int dir = 0; dir < 4; dir++) {
					int nx = cur[0] + dx[dir];
					int ny = cur[1] + dy[dir];

					if (nx < 0 || ny < 0 || n <= nx || m <= ny)
						continue;
					if(vis[nx][ny]) continue;
					
					
					vis[nx][ny] = true;
					int state = chkBoard(nx, ny);
					switch (state) {

					case 0:
						break;

					case 1:
						q.offer(new int[] { nx, ny });
						break;

					case 2:
						q.offer(new int[] { nx, ny });
						key[board[nx][ny] - 'a'] = true;
						open(board[nx][ny] - 'a');

						break;

					case 3:
						if (key[board[nx][ny] - 'A'])
							q.offer(new int[] { nx, ny });
						break;

					case 4:
						docu++;
						q.offer(new int[] { nx, ny });
						break;
					}
				}
			}

			
			System.out.println(docu);
			
		}
	}

	static void open(int idx) {

		for (int i = 0; i < door[idx].size(); i++) {
			int[] p = door[idx].get(i);

			if (vis[p[0]][p[1]])
				q.offer(new int[] { p[0], p[1] });
		}

	}

	static int chkBoard(int x, int y) {

		if (board[x][y] == '*')
			return 0;
		else if (board[x][y] == '.')
			return 1;
		else if (Character.isLowerCase(board[x][y]))
			return 2;
		else if (Character.isUpperCase(board[x][y]))
			return 3;
		else
			return 4;

	}

}