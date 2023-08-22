import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static ArrayList<Integer>[] graph;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++)
			graph[i] = new ArrayList<>();
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b=  Integer.parseInt(st.nextToken());
		
			graph[a].add(b);
			graph[b].add(a);
		}
		
		vis = new boolean[n+1];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {1, 0});
		vis[1] = true;
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] v = q.poll();
			
			for(int nv : graph[v[0]]) {
				if(vis[nv] || v[1] == 2) continue;
				
				vis[nv] = true;
				q.offer(new int[] {nv, v[1]+1});
				cnt++;
				
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
