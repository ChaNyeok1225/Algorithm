import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
 
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 1; tc < T + 1; tc++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		long[][] island = new long[n][2];
    		
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < n; i++) 
    			island[i][0] = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		for(int i = 0; i < n; i++) 
    			island[i][1] = Integer.parseInt(st.nextToken());
    			
    		double e = Double.parseDouble(br.readLine());
    		
    		double[][] graph = new double[n][n];
    		
    		for(int i = 0; i < n-1; i++) {
    			for(int j = i + 1; j < n; j++) {
    				double value = e*((island[i][0] - island[j][0])*(island[i][0] - island[j][0]) + (island[i][1] - island[j][1])*(island[i][1] - island[j][1]));
    				graph[i][j] = value;
    				graph[j][i] = value;
    			}
    		}
    		
    		
    		double[] minEdge = new double[n];
    		boolean[] vis = new boolean[n];
    		Arrays.fill(minEdge, Double.MAX_VALUE);
    		
    		PriorityQueue<Island> pq = new PriorityQueue<>((a,b) -> Double.compare(a.value, b.value));
    		minEdge[0] = 0;
    		pq.offer(new Island(0, minEdge[0]));
    		
    		int cnt =0;
    		double result = 0;
    		while(!pq.isEmpty()) {
    			Island cur = pq.poll();
    			
    			if(vis[cur.no]) continue;
    			
    			result += cur.value;
    			vis[cur.no] = true;
    			if(++cnt == n)
    				break;
    			
    			for(int i = 0; i < n; i++) {
    				if(vis[i]) continue;
    				if(graph[cur.no][i] > 0 && minEdge[i] > graph[cur.no][i]) {
    					minEdge[i] = graph[cur.no][i];
    					pq.offer(new Island(i, minEdge[i]));
    				}
    			}
    		}
    		
    		System.out.printf("#%d %.0f\n",tc,result);
    	}
 
    }
    
    static class Island{
    	int no;
    	double value;
		public Island(int no, double value) {
			this.no = no;
			this.value = value;
		}
    }
    
    
}