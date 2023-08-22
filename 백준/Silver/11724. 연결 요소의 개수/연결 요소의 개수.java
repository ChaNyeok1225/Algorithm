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

		boolean[] vis = new boolean[n+1];
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(graph[a] == null)
				graph[a] = new ArrayList<>();
			if(graph[b] == null)
				graph[b] = new ArrayList<>();
			graph[a].add(b);
			graph[b].add(a);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		int cc = 0;
		
		for(int i = 1; i < n+1; i++) {
			if(vis[i]) continue;
			
			q.offer(i);
			vis[i] = true;
			cc++;
			while(!q.isEmpty()) {
				int v = q.poll();
				
				if(graph[v] != null)
					for(int nv : graph[v]) {
						if(vis[nv]) continue;
						q.offer(nv);
						vis[nv] = true;
					}
			}
		}
		
		System.out.println(cc);

	}

}
