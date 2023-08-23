import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		for(int tc = 1;  tc < 11; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[101];
			boolean[] vis = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n / 2; i++) {
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				if(graph[a] == null)
					graph[a] = new ArrayList<>();
				graph[a].add(b);
			}
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			
			q.offer(new int[] {start,0});
			vis[start] = true;
			int md= -1;
			int mn= -1;
			
			while(!q.isEmpty()) {
				int[] cv = q.poll();
				
				if(md < cv[1] || (md == cv[1] && mn < cv[0])) {
					md = cv[1];
					mn = cv[0];
				} 
				
				if(graph[cv[0]] != null) {
					for(int nv : graph[cv[0]]) {
						if(vis[nv]) continue;
						vis[nv] = true;
						q.offer(new int[] { nv, cv[1]+1});
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,mn);
			
		}
		
	}
}
