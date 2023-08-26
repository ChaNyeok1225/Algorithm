import java.io.*;
import java.util.*;

class Solution {

	static int[][] board;
	static int[] sel, dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static ArrayList<int[]> stair;
	static ArrayList<int[]> person;
	static ArrayList<Integer>[] escape = new ArrayList[2];
	static int n, min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < 2; i++)
			escape[i] = new ArrayList<>();

		for (int tc = 1; tc < T + 1; tc++) {

			n = Integer.parseInt(br.readLine());

			board = new int[n][n];
			stair = new ArrayList<>();
			person = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] > 1)
						stair.add(new int[] { i, j });
					else if (board[i][j] == 1)
						person.add(new int[] { i, j });
				}
			}

			min = Integer.MAX_VALUE;
			sel = new int[person.size()];

			dfs(0);

			System.out.printf("#%d %d\n", tc, min);
		}

	}

	static void dfs(int cnt) {
		if (cnt == person.size()) {

			escape[0].clear();
			escape[1].clear();
			escape[0].add(Integer.MIN_VALUE);
			escape[1].add(Integer.MIN_VALUE);

			for (int i = 0; i < person.size(); i++) {
				int[] pp = person.get(i);
				int[] sp = stair.get(sel[i]);

				int dist = Math.abs(pp[0] - sp[0]) + Math.abs(pp[1] - sp[1]);

				escape[sel[i]].add(dist);
			}

			Collections.sort(escape[0]);
			Collections.sort(escape[1]);

			for (int i = 0; i < 2; i++) {
				int v = board[stair.get(i)[0]][stair.get(i)[1]];

				if (!escape[i].isEmpty() && escape[i].size() > 4) {
					for(int j = 4; j < escape[i].size(); j++)
						escape[i].set(j, Math.max(escape[i].get(j), escape[i].get(j-3)+v));
				}
			}

//			System.out.println("----");
//			System.out.println(Arrays.toString(sel));
//			System.out.println(escape[0]);
//			System.out.println(escape[1]);

			int v1 = escape[0].get(escape[0].size() - 1) + board[stair.get(0)[0]][stair.get(0)[1]] + 1;
			int v2 = escape[1].get(escape[1].size() - 1) + board[stair.get(1)[0]][stair.get(1)[1]] + 1;
			int total = Math.max(v1,v2);
			if (min > total)
				min = total;
			return;
		}

		for (int i = 0; i < 2; i++) {
			sel[cnt] = i;
			dfs(cnt + 1);
		}

	}

	static boolean isRange(int x, int y) {
		return x < 0 || y < 0 || n <= x || n <= y;
	}

}
