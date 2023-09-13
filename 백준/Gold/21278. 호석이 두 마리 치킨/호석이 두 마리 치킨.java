import java.io.*;
import java.util.*;

public class Main {

	static int[] sel = new int[2];
	static boolean[] vis;
	static int n;
	static Queue<int[]> q = new ArrayDeque<>();
	static ArrayList<Integer>[] graph;
	static int max = Integer.MAX_VALUE;
	static int p1, p2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		
		graph = new ArrayList[n + 1];
		vis = new boolean[n+1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			graph[f].add(t);
			graph[t].add(f);
		}

		comb(0, 1);
		
		System.out.println(p1+" "+p2+" "+max);

	}

	private static void comb(int cnt, int idx) {
		
		if (cnt == 2) {
			
			Arrays.fill(vis, false);
			
			for(int i = 0; i < 2; i++) {
				vis[sel[i]] = true;
				
				q.offer(new int[] {sel[i], 0});
			}
			
			int res = 0;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				res += cur[1];
				
				for(int nv : graph[cur[0]]) {
					if(vis[nv]) continue;
					
					vis[nv] = true;
					q.offer(new int[] {nv, cur[1]+2});
				}
				
			}
			
			if(max > res) {
				max = res;
				p1 = sel[0];
				p2 = sel[1];
			}			
			
			return;
		}

		for (int i = idx; i < n + 1; i++) {
			sel[cnt] = i;
			comb(cnt+1, i + 1);
		}
	}
}