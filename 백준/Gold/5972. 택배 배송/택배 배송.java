import java.io.*;
import java.util.*;

//start	2023. 12. 15  14 : 52
//end	2023. 12. 15  15 : 09
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<int[]>[] graph = new ArrayList[n + 1]; // 인접 리스트 초기화
		for (int i = 1; i < n + 1; i++) {
			graph[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[from].add(new int[] { to, w }); // 양방향 입력
			graph[to].add(new int[] { from, w });
		}

		// PQ 다익스트라
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]); 

		int[] minEdge = new int[n + 1]; // minEdge 배열 초기화
		Arrays.fill(minEdge, Integer.MAX_VALUE);

		boolean[] vis = new boolean[n + 1]; // 방문체크 배열

		minEdge[1] = 0; // 시작 정점
		q.offer(new int[] { 1, minEdge[1] });

		int ans = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (vis[cur[0]])
				continue;

			vis[cur[0]] = true;
			if (cur[0] == n) {
				ans = cur[1];
				break;
			}

			for (int[] nxt : graph[cur[0]]) {
				if (minEdge[nxt[0]] <= nxt[1] + cur[1])
					continue;
				minEdge[nxt[0]] = nxt[1] + cur[1];
				q.offer(new int[] { nxt[0], minEdge[nxt[0]] });
			}
		}
		
		System.out.println(ans);
		

	}
}