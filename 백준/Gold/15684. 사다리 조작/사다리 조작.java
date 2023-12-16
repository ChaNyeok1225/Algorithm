import java.io.*;
import java.util.*;

//start	2023. 12. 16  19 : 24
//end	2023. 12. 16  20 : 06
public class Main {

	static int[][] line;
	static int n, h, total, ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		total = n * h;
		line = new int[h][n];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++)
				line[i][j] = j;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			line[a][b] = b + 1;
			line[a][b + 1] = b;
		}

		ans = Integer.MAX_VALUE;

		dfs(0, 0);

		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	static void dfs(int idx, int cnt) {
		if (idx == total)
			return;

		if (chk()) {
			ans = ans < cnt ? ans : cnt;
			return;
		}

		int a = idx / n;
		int b = idx % n;

		if (cnt < 3) {
			dfs(idx + 1, cnt);
			if (b != n - 1 && line[a][b] == b && line[a][b + 1] == b + 1) {
				line[a][b] = b + 1;
				line[a][b + 1] = b;
				dfs(idx + 1, cnt + 1);
				line[a][b] = b;
				line[a][b + 1] = b + 1;
			}
		}
	}

	static boolean chk() {
		for (int i = 0; i < n; i++) {
			int cur = i;
			for (int j = 0; j < h; j++)
				cur = line[j][cur];
			if (cur != i)
				return false;
		}
		return true;
	}

}