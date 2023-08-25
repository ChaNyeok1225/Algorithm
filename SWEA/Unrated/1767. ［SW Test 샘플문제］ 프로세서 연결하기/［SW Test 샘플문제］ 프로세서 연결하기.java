import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] board;
	static ArrayList<int[]> processor;
	static int size, min, n, maxconnect;

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			n = Integer.parseInt(br.readLine());

			board = new int[n][n];
			processor = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1)
						processor.add(new int[] { i, j });
				}
			}
			size = processor.size();
			min = Integer.MAX_VALUE;
			maxconnect = -1;
			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", tc, min);
		}
	}

	private static void dfs(int idx, int sum, int connect) {
//		System.out.println(idx + "--- sum : " + sum);
//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(board[i]));
//		System.out.println();

		if (maxconnect < connect) {
			maxconnect = connect;
			min = sum;
		}
		if (maxconnect == connect && min > sum)
			min = sum;

		if (idx == size) 
			return;

		int[] p = processor.get(idx);
		int nx = p[0], ny = p[1], cnt = 0;
		boolean flag = false;
		boolean conchk = true;
		for (int dir = 0; dir < 4; dir++) {
			flag = false;
			cnt = 0;
			nx = p[0];
			ny = p[1];
			while (true) { // 본인 영역으로 칠하기
				nx += dx[dir];
				ny += dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || n <= ny) { // 전기에 닿았다면 flag = true 하고 break
					flag = true;
					conchk = false;
					break;
				}
				if (board[nx][ny] != 0)
					break;

				board[nx][ny] = idx + 2;
				cnt++;
			}

			if (flag) // 전기에 닿았다면 다음 단계로
				dfs(idx + 1, sum + cnt, connect + 1);

			nx = p[0];
			ny = p[1];
			while (true) { // 복원
				nx += dx[dir];
				ny += dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || n <= ny)
					break;

				if (board[nx][ny] == idx + 2) {
					board[nx][ny] = 0;
				} else
					break;
			}
		}
		dfs(idx+1, sum, connect);
	}

}
