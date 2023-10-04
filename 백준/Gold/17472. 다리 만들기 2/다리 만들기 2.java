import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m, p[];

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][] vis = new int[n][m];
		Queue<int[]> q = new ArrayDeque<int[]>();
		int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

		int idx = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] == 0 && board[i][j] == 1) {
					vis[i][j] = idx;
					q.offer(new int[] { i, j });

					while (!q.isEmpty()) {
						int[] p = q.poll();

						for (int dir = 0; dir < 4; dir++) {
							int nx = p[0] + dx[dir];
							int ny = p[1] + dy[dir];

							if (chk(nx, ny))
								continue;
							if (board[nx][ny] == 0 || vis[nx][ny] != 0)
								continue;

							vis[nx][ny] = idx;
							q.offer(new int[] { nx, ny });
						}
					}

					idx++;
				}
			}
		}

		p = new int[idx];
		for (int i = 1; i < idx; i++)
			p[i] = i;
		

		List<int[]> list = new ArrayList<int[]>();

		int w = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] != 0) {

					for (int dir = 0; dir < 4; dir++) {
						w = 1;

						while (true) {

							int nx = i + dx[dir] * w;
							int ny = j + dy[dir] * w;

							if (chk(nx, ny))
								break;
							if (vis[nx][ny] != 0) {
								if (w > 2 && vis[i][j] != vis[nx][ny])
									list.add(new int[] { vis[i][j], vis[nx][ny], w - 1 });
								break;
							}
							w++;
						}
					}
				}
			}
		}

		Collections.sort(list, (a,b) -> a[2] - b[2]);
		
		int cnt = 0, res = 0;
		for(int i = 0; i < list.size(); i++) {
			
			int[] cur = list.get(i);
			if(union(cur[0], cur[1])) {
				res += cur[2];
				cnt++;
				if(cnt == idx-2)
					break;
			}
		}
		
		if(cnt == idx - 2)
			System.out.println(res);
		else
			System.out.println(-1);
		
	}

	static boolean chk(int nx, int ny) {
		return nx < 0 || ny < 0 || n <= nx || m <= ny;
	}

	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		
		p[b] = a;
		return true;
	}
}