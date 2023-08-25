import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] graph = new ArrayList[v+1];
		for(int i = 1; i < v + 1; i++)
			graph[i] = new ArrayList<>();
		
		int start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i  < e ; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t,w});
		}
		
		int[] minEdge = new int[v+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1]-b[1] );  
		minEdge[start] = 0;
		pq.offer(new int[] { start, minEdge[start]});
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			for(int[] nv : graph[cur[0]]) {
				if(minEdge[nv[0]] > minEdge[cur[0]] + nv[1])  {
					minEdge[nv[0]] = minEdge[cur[0]] + nv[1];
					pq.offer(new int[] {nv[0], minEdge[nv[0]]});
				}
			}
			
		}
		
		for(int i = 1; i < v + 1; i++) {
			if(minEdge[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(minEdge[i]+"\n");
		}
		
		System.out.print(sb);
		
	}
}