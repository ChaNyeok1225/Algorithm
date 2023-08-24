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

		ArrayList<int[]>[] graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new int[] { b, w ^ 1 });
			graph[b].add(new int[] { a, w ^ 1 });
		}
//
//		for (int i = 0; i < n + 1; i++) {
//			for (int[] p : graph[i])
//				System.out.print(Arrays.toString(p) + " ");
//			System.out.println();
//		}

		int result1 = 0, result2 = 0;

		int[] minEdge = new int[n + 1];
		int[] maxEdge = new int[n + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		Arrays.fill(maxEdge, Integer.MIN_VALUE);

		boolean[] vis1 = new boolean[n + 1];
		boolean[] vis2 = new boolean[n + 1];

		minEdge[0] = 0;
		maxEdge[0] = 0;

		PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq1.offer(new int[] { 0, 0 });
		int cnt1 = 0;
		while (!pq1.isEmpty()) {
			int[] v = pq1.poll();

			if (vis1[v[0]])
				continue;

			vis1[v[0]] = true;
			result1 += v[1];
			if (++cnt1 == n+1)
				break;

			for (int[] nv : graph[v[0]]) {
				if (vis1[nv[0]])
					continue;
				if (minEdge[nv[0]] > nv[1]) {
					minEdge[nv[0]] = nv[1];
					pq1.offer(nv);
				}
			}
		}

		PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		pq2.offer(new int[] { 0, 0 });
		int cnt2 = 0;
		while (!pq2.isEmpty()) {
			int[] v = pq2.poll();

			if (vis2[v[0]])
				continue;

			vis2[v[0]] = true;
			result2 += v[1];
			if (++cnt2 == n+1)
				break;

			for (int[] nv : graph[v[0]]) {
				if (vis2[nv[0]])
					continue;
				if (maxEdge[nv[0]] < nv[1]) {
					maxEdge[nv[0]] = nv[1];
					pq2.offer(nv);
				}
			}
		}
		
		System.out.println(result2*result2 - result1*result1);
	}
}
