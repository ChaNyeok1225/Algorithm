import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[] button = new boolean[10];
	static int target, bm = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		target = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		button = new boolean[10];

		if (n > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				button[Integer.parseInt(st.nextToken())] = true;
		}
		bm = Math.abs(target - 100);

		dfs(0, 0);

		System.out.println(bm);

	}

	static void dfs(int cnt, int sum) {
		if (cnt > 6)
			return;

		if (cnt > 0) {
			int cal = cnt + Math.abs(target - sum);

			if (cal < bm) {
				bm = cal;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (button[i])
				continue;

			dfs(cnt + 1, sum * 10 + i);
		}

	}

}
