import java.io.*;
import java.util.*;

public class Main {

	static boolean[] vis;
	static int[] dx = { 1, 0 }, dy = { 0, 1 }, board[];
	static int n, l;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 1; // Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			board = new int[n][n];
			vis = new boolean[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					board[i][j] = Integer.parseInt(st.nextToken());
			}

			int[] arr = new int[n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					arr[j] = board[i][j];
				cnt += chk(arr);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					arr[j] = board[j][i];
				cnt += chk(arr);
			}
			System.out.println(cnt);
		}

	}

	static int chk(int[] arr) {

		Arrays.fill(vis, false);

		for (int i = 1; i < n; i++) {
			if (Math.abs(arr[i - 1] - arr[i]) == 1) {
				switch (arr[i-1] - arr[i]) {
				
				case -1:

					if (vis[i - 1])
						return 0;

					vis[i - 1] = true;
					for (int k = 1; k < l; k++) {
						if (i - k - 1 < 0)
							return 0;
						if (arr[i - k] != arr[i - k - 1])
							return 0;
						if (vis[i - k - 1])
							return 0;
						vis[i - k - 1] = true;
					}
					break;

				case 1:
					vis[i] = true;
					for (int k = 1; k < l; k++) {
						if (n <= i + k)
							return 0;
						if (arr[i + k] != arr[i + k - 1])
							return 0;
						vis[i + k] = true;
					}
					break;

				}

			} else if (Math.abs(arr[i - 1] - arr[i]) > 1)
				return 0;
		}

		return 1;
	}

}
