import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<int[]>[] graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[t].add(new int[] { f, w });
		}

		int[] interview = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++)
			interview[i] = Integer.parseInt(st.nextToken());

		boolean[] vis = new boolean[n + 1];
		long[] minEdge = new long[n + 1];

		long max = 0;
		int midx = 0;

		PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
		Arrays.fill(minEdge, Long.MAX_VALUE);
		Arrays.fill(vis, false);
		for(int i = 0; i < k; i++) {
			minEdge[interview[i]] = 0;
			q.offer(new long[] { interview[i], 0 });
		}
		
		int cnt = 0;
		while (!q.isEmpty()) {
			long[] cv = q.poll();

			if (vis[(int) cv[0]])
				continue;

			vis[(int) cv[0]] = true;
			if (++cnt == n)
				break;

			for (int[] nv : graph[(int) cv[0]]) {
				if (vis[nv[0]])
					continue;

				if (minEdge[nv[0]] > minEdge[(int) cv[0]] + nv[1]) {
					minEdge[nv[0]] = minEdge[(int) cv[0]] + nv[1];
					q.offer(new long[] { nv[0], minEdge[nv[0]] });
				}
			}
		}

		for (int i = 1; i < n + 1; i++)
			if (minEdge[i] > max) {
				max = minEdge[i];
				midx = i;
			}

		System.out.println(midx);
		System.out.println(max);
	}
}
