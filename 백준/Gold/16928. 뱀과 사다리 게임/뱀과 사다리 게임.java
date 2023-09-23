import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] board = new int[10][10];
		int[][] dist = new int[10][10];
		for (int i = 0; i < 10; i++)
			Arrays.fill(dist[i], -1);

		for (int i = 0; i < n + m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			board[s / 10][s % 10] = e;
		}

		Queue<Integer> q = new ArrayDeque<>();

		q.offer(0);
		dist[0][0] = 0;

		while (!q.isEmpty()) {
			int p = q.poll();

			for (int i = 1; i < 7; i++) {
				int np = p + i;
				if (np >= 100)
					continue;

				if (dist[np / 10][np % 10] >= 0)
					continue;

				dist[np / 10][np % 10] = dist[p / 10][p % 10] + 1;
				if (board[np / 10][np % 10] > 0) {
					int e = board[np / 10][np % 10];
					if (dist[e / 10][e % 10] == -1) {
						dist[e / 10][e % 10] = dist[p / 10][p % 10] + 1;
						q.offer(e);
					}
				} else
					q.offer(np);
			}
		}

		System.out.println(dist[9][9]);

	}
}