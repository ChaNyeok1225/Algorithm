import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n][n];
	
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int w = Integer.parseInt(st.nextToken());
				graph[i][j] = w;
				graph[j][i] = w;
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);

		int[] minEdge = new int[n];
		boolean[] vis = new boolean[n];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[0] = 0;
		q.offer(new int[] {0, minEdge[0]});
		long result = 0;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(vis[p[0]]) continue;
			
			vis[p[0]] = true;
			result += p[1];
			
			for(int i = 0; i < n; i++) {
				if(vis[i]) continue;
				
				if(graph[p[0]][i] == 0)
					continue;
				
				if(minEdge[i] > graph[p[0]][i]) {
					minEdge[i] = graph[p[0]][i];
					q.offer(new int[] {i, minEdge[i]});
				}
			}
		}
		
		System.out.println(result);
		
	}
}
