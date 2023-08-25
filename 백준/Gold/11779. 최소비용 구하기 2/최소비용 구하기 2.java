import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] graph = new ArrayList[n+1];
		for(int i = 1; i < n +1; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st= new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t,w});
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1] );

		boolean[] vis = new boolean[n+1];
		int[] minEdge = new int[n+1];
		int[] path = new int[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[start] = 0;
		pq.offer(new int[] {start, minEdge[start]});
		
		while(!pq.isEmpty()) {
			int[] cv = pq.poll();
			
			if(vis[cv[0]]) continue;
			if(cv[0] == end)
				break;
			vis[cv[0]] = true;
			
			for(int[] nv : graph[cv[0]]) {
				if(vis[nv[0]]) continue;
				
				if(minEdge[nv[0]] > minEdge[cv[0]] + nv[1]) {
					path[nv[0]] = cv[0];
					minEdge[nv[0]] = minEdge[cv[0]] + nv[1];
					pq.offer(new int[] {nv[0], minEdge[nv[0]]});
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		int cur = end;
		int cnt = 0;
		while(cur != 0) {
			list.add(cur);
			cur = path[cur];
			cnt++;
		}
		
		System.out.println(minEdge[end] +"\n"+cnt);
		for(int i = list.size()-1; i >= 0; i--)
			sb.append(list.get(i) + " ");
		System.out.println(sb);
		
	}

}
