import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 }, dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static char[][] board;
	static HashMap<String, Integer> map = new HashMap<>();
	static int n, m;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		board = new char[n][];

		for (int i = 0; i < n; i++)
			board[i] = br.readLine().toCharArray();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.setLength(0);
				sb.append(board[i][j]);
				dfs(i, j, 1);
			}
		}
		sb.setLength(0);
		for(int i = 0; i < k; i++) 
			sb.append(map.getOrDefault(br.readLine(), 0) + "\n");
		System.out.println(sb);
	}

	private static void dfs(int x, int y, int cnt) {
		map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

		if (cnt == 5)
			return;

		for (int dir = 0; dir < 8; dir++) {
			int nx = (n + x + dx[dir]) % n;
			int ny = (m + y + dy[dir]) % m;
			
			sb.append(board[nx][ny]);
			dfs(nx, ny, cnt + 1);
			sb.setLength(sb.length()-1);

		}

	}

}
