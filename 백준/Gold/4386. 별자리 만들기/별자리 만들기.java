import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		double[][] star = new double[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		
		double[][] graph = new double[n][n];
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i + 1; j < n; j++) {
				double xdis = Math.abs(star[i][0] - star[j][0]);
				double ydis = Math.abs(star[i][1] - star[j][1]);
				double val = Math.sqrt(xdis*xdis + ydis*ydis);
				graph[i][j] = val;
				graph[j][i] = val;
			}
		}
		
		PriorityQueue<double[]> pq = new  PriorityQueue<>((a,b) -> Double.compare(a[1],b[1]));
		double[] minEdge = new double[n];
		Arrays.fill(minEdge, Double.MAX_VALUE);
		
		boolean[] vis = new boolean[n];
		
		minEdge[0] = 0;
		pq.offer(new double[] {0,0});
		
		double result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			double[] cur = pq.poll();
			
			if(vis[(int)cur[0]]) continue;
			
			result += cur[1];
			vis[(int)cur[0]] = true;
			if(++cnt == n)
				break;
			
			for(int i = 0; i < n; i++) {
				if(vis[i]) continue;
				
				if(graph[(int)cur[0]][i] > 0 && minEdge[i] > graph[(int)cur[0]][i]) {
					minEdge[i] = graph[(int)cur[0]][i];
					pq.offer(new double[] {i, minEdge[i]});
				}
			}
		}
		
		System.out.printf("%.2f",result);
		
	}
}