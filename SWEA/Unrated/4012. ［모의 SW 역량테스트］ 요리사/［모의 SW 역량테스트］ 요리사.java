import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static boolean[] group;
	static int[][] taste;

	static int bal;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			n = Integer.parseInt(br.readLine());

			group = new boolean[n + 1];
			taste = new int[n + 1][n + 1];
			bal = Integer.MAX_VALUE;

			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++)
					taste[i][j] = Integer.parseInt(st.nextToken());
			}

			func(0, 1, n / 2);
			System.out.printf("#%d %d\n",tc,bal);
		}
	}

	static void func(int cnt, int idx, int end) {
		if (cnt == n / 2) {
			int A = 0;
			int B = 0;
			for (int i = 1; i < n + 1; i++) {
				for (int j = i; j < n + 1; j++) {
					if (group[i] == group[j]) {
						if (group[i])
							A += taste[i][j] + taste[j][i];
						else
							B += taste[i][j] + taste[j][i];
					}
				}
			}

			int b = Math.abs(A - B);
			if (b < bal)
				bal = b;

			return;
		}

		for (int i = idx; i < end; i++) {
			group[i] = true;
			func(cnt + 1, i + 1, n + 1);
			group[i] = false;
		}
	}
}
