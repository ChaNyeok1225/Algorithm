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
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		int[] minEdge = new int[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		st = new StringTokenizer(br.readLine().trim());
		for(int i = 0; i < k; i++) {
			int v = Integer.parseInt(st.nextToken());
			minEdge[v] = 0;
			pq.offer(new int[] {v, minEdge[v]});
		}
		
		ArrayList<int[]>[] graph = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t,w});
			graph[t].add(new int[] {f,w});
		}
		
		
		int cnt = 0;
		long result = 0;
		boolean[] vis = new boolean[n+1];
		
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(vis[cur[0]]) continue;
			
			result += cur[1];
			vis[cur[0]] = true;
			if(++cnt == n)
				break;
			
			for(int[] nv : graph[cur[0]]) {
				if(vis[nv[0]]) continue;
				if(minEdge[nv[0]] > nv[1]) {
					minEdge[nv[0]] = nv[1];
					pq.offer(nv);
				}
			}
		}
		
		System.out.println(result);
		
		
	}

}