import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] nums;
	static int[] oper;
	static int[] opercnt = new int[4];

	static int n;

	static int max = -100_000_000;
	static int min = 100_000_000;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			min = 100_000_000;
			max = -100_000_000;
			n = Integer.parseInt(br.readLine());
			nums = new int[n];
			oper = new int[n];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opercnt[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0);

			System.out.printf("#%d %d\n", tc, max-min);
		}
	}

	private static void dfs(int cnt) {
		if (cnt == n - 1) {
			int[] tmp = nums.clone();

			for (int i = 0; i < n - 1; i++) {
				switch (oper[i]) {
				case 0:
					tmp[i + 1] = tmp[i] + tmp[i + 1];
					break;
				case 1:
					tmp[i + 1] = tmp[i] - tmp[i + 1];
					break;
				case 2:
					tmp[i + 1] = tmp[i] * tmp[i + 1];
					break;
				case 3:
					tmp[i + 1] = tmp[i] / tmp[i + 1];
					break;
				}
			}
			if (tmp[n - 1] > max)
				max = (int) tmp[n - 1];
			if (tmp[n - 1] < min)
				min = (int) tmp[n - 1];

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (opercnt[i] <= 0)
				continue;
			oper[cnt] = i;
			opercnt[i]--;
			dfs(cnt + 1);
			opercnt[i]++;
		}
	}

}
