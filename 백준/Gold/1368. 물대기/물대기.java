import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[] minEdge = new int[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int[][] graph = new int[n+1][n+1];
		for(int i = 1; i < n+1; i++) {
			int w = Integer.parseInt(br.readLine());
			graph[0][i] = w;
			graph[i][0] = w;
		}
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1] );
		boolean[] vis = new boolean[n+1];
		minEdge[0] = 0;
		pq.offer(new int[] {0,minEdge[0]});
		
		int cnt = 0, result = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(vis[cur[0]]) continue;
			
			vis[cur[0]] = true;
			result += cur[1];
			if(++cnt==n+1)
				break;
			
			for(int i = 0; i < n+1; i++) {
				if(vis[i]) continue;
				if(graph[cur[0]][i] > 0 && minEdge[i] > graph[cur[0]][i]) {
					minEdge[i] = graph[cur[0]][i];
					pq.offer(new int[] {i, minEdge[i]});
				}
			}
		}
		
		System.out.println(result);
		
	}

}