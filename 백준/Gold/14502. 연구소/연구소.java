import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int[][] board;

	static List<int[]> virus = new ArrayList<int[]>();
	static List<int[]> free = new ArrayList<int[]>();

	static int max = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		int num;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				if (num == 0)
					free.add(new int[] { i, j });
				else if (num == 2)
					virus.add(new int[] { i, j });
			}
		}

		dfs(0, 0);
		
		System.out.println(max);

	}

	private static void dfs(int idx, int cnt) {
		if (cnt == 3) {
			max = Math.max(max, free.size() -3 - bfs());
			return;
		}

		for (int i = idx; i < free.size(); i++) {
			int[] p = free.get(i);
			board[p[0]][p[1]] = 3;
			dfs(i + 1, cnt + 1);
			board[p[0]][p[1]] = 0;
		}
	}

	private static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		boolean[][] vis = new boolean[n][m];

		for (int i = 0; i < virus.size(); i++) {
			int[] p = virus.get(i);
			q.add(p);
			vis[p[0]][p[1]] = true;
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] p = q.pop();

			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(nx < 0 || ny < 0 || n <= nx || m <= ny)
					continue;
				if(vis[nx][ny] || board[nx][ny] != 0)
					continue;
				
				vis[nx][ny] = true;
				cnt++;
				q.add(new int[] {nx,ny});
				
			}
		}

		return cnt;
	}

}
