import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		int[] kevin = new int[n + 1];
		boolean[][] vis = new boolean[n + 1][n + 1];
		Queue<int[]> q = new ArrayDeque<int[]>();

		for (int i = 1; i < n + 1; i++) {
			q.offer(new int[] { i, 0 });
			vis[i][i] = true;

			while (!q.isEmpty()) {
				int[] cv = q.poll();
				kevin[i] += cv[1];

				for (int nv : graph[cv[0]]) {
					if (vis[i][nv])
						continue;
					vis[i][nv] = true;
					q.offer(new int[] { nv, cv[1] + 1 });
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int minidx = 0;
		for (int i = 1; i < n + 1; i++)
			if (kevin[i] < min) {
				min = kevin[i];
				minidx = i;
			}
		System.out.println(minidx);
	}

}
