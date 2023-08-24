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

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[from].add(new int[] { to, w });
			graph[to].add(new int[] {from, w });
		}

		int[] minEdge = new int[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		boolean[] vis = new boolean[n+1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		
		minEdge[1] = 0;
		pq.offer(new int[] {1,minEdge[1]});
		
		int cnt = 0, result = 0, max = 0;
		while(!pq.isEmpty()) {
			int[] p = pq.poll();
//			System.out.println(p[0] + ", " + p[1]);
			
			if(vis[p[0]]) continue;
			
			if(max < p[1])
				max = p[1];
			result += p[1];
			vis[p[0]] = true;
			if(++cnt == n)
				break;
			for(int[] nv : graph[p[0]]) {
				if(vis[nv[0]]) continue;
				
				if(minEdge[nv[0]] > nv[1]) {
					minEdge[nv[0]] = nv[1];
					pq.offer(nv);
				}
			}
		}
		System.out.println(result - max);
	}
}
