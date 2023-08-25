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
		int x = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] graph = new ArrayList[n+1];
		for(int i =1; i < n +1; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t,w});
		}
		int[] gtime = new int[n+1];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		for(int i = 1; i < n+1; i++) {
			boolean[] vis = new boolean[n+1];
			int[] minEdge = new int[n+1];
			Arrays.fill(minEdge,Integer.MAX_VALUE);
			pq.clear();
			minEdge[i] = 0;
			pq.offer(new int[] {i, minEdge[i]});
			
			int cnt = 0;
			while(!pq.isEmpty()) {
				int[] cv = pq.poll();
				
				if(vis[cv[0]]) continue;
				vis[cv[0]] = true;
				if(++cnt == n)
					break;
				
				for(int[] nv : graph[cv[0]]) {
					if(vis[nv[0]]) continue;
					
					if(minEdge[nv[0]] > minEdge[cv[0]] + nv[1]) {
						minEdge[nv[0]] = minEdge[cv[0]] + nv[1];
						pq.offer(new int[] {nv[0], minEdge[nv[0]]});
					}
				}
				
			}
			gtime[i] += minEdge[x];
			if(i == x) {
				for(int j = 1; j < n +1; j++)
					gtime[j] += minEdge[j];
			}
		}
		int max = 0;
		for(int i = 1; i < n+1; i++)
			if(max < gtime[i])
				max = gtime[i];
		
		System.out.println(max);
	}

}
