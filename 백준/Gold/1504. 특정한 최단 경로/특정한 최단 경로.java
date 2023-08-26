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

		ArrayList<int[]>[] graph = new ArrayList[n+1];
		
		for(int i = 1; i < n +1; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t,w});
			graph[t].add(new int[] {f,w});
		}
		
		int[][] minEdge = new int[3][n+1];
		for(int i = 0; i < 3; i++)
			Arrays.fill(minEdge[i], Integer.MAX_VALUE);
		
		int[] path = new int[4];
		path[0] = 1;
		path[3] = n;
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i < 2; i++)
			path[i+1] = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		
		for(int i = 0; i < 3; i++) {
			minEdge[i][path[i]] = 0;
			pq.offer(new int[] {path[i], minEdge[i][path[i]]});
			
			boolean[] vis = new boolean[n+1];
			
			int cnt = 0;
			while(!pq.isEmpty()) {
				int[] cv = pq.poll();
				
				if(vis[cv[0]]) continue;
				
				vis[cv[0]] = true;
				if(++cnt == n)
					break;
				for(int[] nv : graph[cv[0]]) {
					if(vis[nv[0]]) continue;
					
					if(minEdge[i][nv[0]] > minEdge[i][cv[0]] + nv[1]) {
						minEdge[i][nv[0]] = minEdge[i][cv[0]] + nv[1];
						pq.offer(new int[] {nv[0], minEdge[i][nv[0]]});
					}
				}
			}
		}
		
		long val1 = (long)minEdge[0][path[1]] + minEdge[1][path[2]] + minEdge[2][n];
		long val2 = (long)minEdge[0][path[2]] + minEdge[2][path[1]] + minEdge[1][n];
		
		long res = Math.min(val1, val2);
		if(res >= Integer.MAX_VALUE)
			res = -1;
		
		System.out.println(res);
		
		
	}
}
