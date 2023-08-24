import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		
		double[][] graph = new double[n+1][n+1];
		
		long[][] god = new long[n+1][2];
		double[] minEdge = new double[n+1];
		Arrays.fill(minEdge, Double.MAX_VALUE);
		
		boolean[] vis = new boolean[n+1];
		
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			god[i][0] = Integer.parseInt(st.nextToken());
			god[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n +1 ;i++)
			Arrays.fill(graph[i], -1);
		
		for(int i = 1; i < n; i++) {
			for(int j = i+1; j< n+1 ; j++) {
				double val = (god[i][0] - god[j][0])*(god[i][0] - god[j][0]) + (god[i][1] - god[j][1])*(god[i][1] - god[j][1]) ; 
				val = Math.sqrt(val);
				graph[i][j] = val;
				graph[j][i] = val;
			}
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 0;
			graph[b][a] = 0;
		}
		
		PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[1],b[1]));
		minEdge[1] = 0;
		pq.offer(new double[] {1, 0});
		
//		for(int i = 1; i < n + 1; i++)
//			System.out.println(Arrays.toString(graph[i]));
		
		double result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			double[] v= pq.poll();
			
			if(vis[(int) v[0]]) continue;
			
			vis[(int) v[0]] =true;
			result += v[1];
			if(++cnt == n)
				break;
			
			for(int i = 1; i < n+1; i++) {
				if(vis[i]) continue;
				if(graph[(int) v[0]][i] == -1)
					continue;
				if(minEdge[i] > graph[(int) v[0]][i]) {
					minEdge[i] = graph[(int) v[0]][i];
					pq.offer(new double[] {i, minEdge[i]});
				}
			}
		}
		
		System.out.printf("%.2f",result);
		
	}
}
