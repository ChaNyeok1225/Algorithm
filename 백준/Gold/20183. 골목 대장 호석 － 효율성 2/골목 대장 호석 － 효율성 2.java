import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		ArrayList<int[]>[] graph = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t,w});
			graph[t].add(new int[] {f,w});
		}
		
		boolean[] vis = new boolean[n+1];
		
		PriorityQueue<long[]> q= new PriorityQueue<>((a,b) -> Long.compare(a[2],b[2]));
		long[] minEdge = new long[n+1];
		long[] cost = new long[n+1];
		
		Arrays.fill(cost, Long.MAX_VALUE);
		Arrays.fill(minEdge, Long.MAX_VALUE);
		
		minEdge[start] = 0;
		cost[start] = 0;
		q.offer(new long[] {start, 0, 0});
		
		int cnt = 0;
		while(!q.isEmpty()) {
			long[] cv = q.poll();
			
			if(vis[(int)cv[0]]) continue;
			
			vis[(int)cv[0]] = true;
			if(++cnt==n)
				break;
			
			for(int[] nv : graph[(int)cv[0]]) {
				if(vis[nv[0]]) continue;
				
				if(c >= minEdge[(int)cv[0]] + nv[1] && cost[nv[0]] > Math.max(cv[2],nv[1])) {
					minEdge[nv[0]] = minEdge[(int)cv[0]] + nv[1];
					cost[nv[0]] = Math.max(cv[2],nv[1]);
					q.offer(new long[] {nv[0], minEdge[(int)nv[0]], cost[(int)nv[0]]});
				}
			}
		}
	
		long res = cost[end];
		if(res == Long.MAX_VALUE)
			res = -1;
		
		System.out.println(res);
	}
}
