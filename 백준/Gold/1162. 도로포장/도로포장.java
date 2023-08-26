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

			graph[f].add(new int[] { t, w, 0 });
			graph[f].add(new int[] { t, 0, 1 });
			graph[t].add(new int[] { f, w, 0 });
			graph[t].add(new int[] { f, 0, 1 });
		}
		
		PriorityQueue<long[]> q = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
		boolean[][] vis = new boolean[k+1][n+1];
		long[][] minEdge = new long[k+1][n+1];
		
		for(int i = 0; i < k+1; i++)
			Arrays.fill(minEdge[i], Long.MAX_VALUE);
		
		for(int i = 0; i < k + 1; i++)
			minEdge[i][1] = 0;
		q.offer(new long[] {1,minEdge[0][1],0});
		
		while(!q.isEmpty()) {
			long[] cv = q.poll();
			
			if(vis[(int)cv[2]][(int)cv[0]]) continue;
			vis[(int)cv[2]][(int)cv[0]] = true;
			
			for(int[] nv : graph[(int)cv[0]]) {
				
				if(cv[2] + nv[2] > k)
					continue;
				if(vis[(int)(cv[2] + nv[2])][(int)nv[0]]) continue;
				
				if(minEdge[(int)(cv[2] + nv[2])][nv[0]] > minEdge[(int)cv[2]][(int)cv[0]] + nv[1]) {
					minEdge[(int)(cv[2] + nv[2])][nv[0]] = minEdge[(int)cv[2]][(int)cv[0]] + nv[1];
					q.offer(new long[] {nv[0], minEdge[(int)(cv[2] + nv[2])][nv[0]], cv[2] + nv[2]});
				}
			}
		}
		
		long ans = Long.MAX_VALUE;
		for(int i = 0; i < k +1; i++)
			if(ans > minEdge[i][n])
				ans = minEdge[i][n];

		System.out.println(ans);
	}

}
