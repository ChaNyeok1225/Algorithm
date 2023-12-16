//start	2023. 12. 16  17 : 20
//end	2023. 12. 16  17 : 28
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if(n == 0 && m == 0)
				break;
			
			List<int[]>[] graph = new ArrayList[n]; // 인접 리스트
			for (int i = 0; i < n; i++)
				graph[i] = new ArrayList<int[]>();

			int total = 0;
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				graph[from].add(new int[] { to, w });
				graph[to].add(new int[] { from, w });
				total += w; // 총합
			}

			// PRIM MST
			PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

			boolean[] vis = new boolean[n];
			int[] minEdge = new int[n];
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			minEdge[0] = 0;

			q.offer(new int[] { 0, minEdge[0] });

			int cnt = 0;
			int sum = 0;

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (vis[cur[0]])
					continue;

				vis[cur[0]] = true;
				cnt++;
				sum += cur[1];
				if (cnt == n)
					break;

				for (int[] nxt : graph[cur[0]]) {
					if (minEdge[nxt[0]] <= nxt[1])
						continue;
					minEdge[nxt[0]] = nxt[1];
					q.offer(new int[] { nxt[0], minEdge[nxt[0]] });
				}
			}

			sb.append(total-sum).append("\n");
		}

		System.out.print(sb);
	}
}