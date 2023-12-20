import java.io.*;
import java.util.*;

// start	2023. 12. 20  14 : 07
// end 		2023. 12. 20  14 : 16
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			List<int[]>[] graph = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++)
				graph[i] = new ArrayList<int[]>();

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[to].add(new int[] { from, w });
			}

			int[] minEdge = new int[n + 1];
			Arrays.fill(minEdge, Integer.MAX_VALUE);

			boolean[] vis = new boolean[n + 1];
			minEdge[c] = 0;
			int cnt = 0;
			int ans = 0;

			PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
			q.offer(new int[] { c, minEdge[c] });

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (vis[cur[0]])
					continue;

				vis[cur[0]] = true;
				cnt++;
				ans = cur[1];
				if (cnt == n)
					break;

				for (int[] nxt : graph[cur[0]]) {
					if (minEdge[nxt[0]] <= cur[1] + nxt[1])
						continue;
					minEdge[nxt[0]] = cur[1] + nxt[1];
					q.offer(new int[] { nxt[0], minEdge[nxt[0]] });
				}
			}
			
			sb.append(cnt).append(" ").append(ans).append("\n");
		}

		System.out.print(sb);
	}
}