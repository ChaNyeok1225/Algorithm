import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			ArrayList<Integer>[] ingraph = new ArrayList[n + 1];
			ArrayList<Integer>[] outgraph = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++) {
				ingraph[i] = new ArrayList<>();
				outgraph[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				ingraph[b].add(a);
				outgraph[a].add(b);
			}

			boolean[] vis = new boolean[n+1];
			
			Queue<Integer> q = new ArrayDeque<Integer>();
			int res = 0;
			for (int i = 1; i < n + 1; i++) {
				int cnt = 1;
				vis[i] = true;
					
				q.offer(i);
				while(!q.isEmpty()) {
					int c = q.poll();
					
					for(int nxt : ingraph[c]) {
						if(vis[nxt]) continue;
						vis[nxt] = true;
						q.offer(nxt);
						cnt++;
					}
				}
				
				q.offer(i);
				while(!q.isEmpty()) {
					int c = q.poll();
					
					for(int nxt : outgraph[c]) {
						if(vis[nxt]) continue;
						vis[nxt] = true;
						q.offer(nxt);
						cnt++;
					}
				}
				
				if(cnt == n)
					res++;
					
				Arrays.fill(vis, false);
			}
			
			System.out.printf("#%d %d\n", tc, res);
		}

	}

}