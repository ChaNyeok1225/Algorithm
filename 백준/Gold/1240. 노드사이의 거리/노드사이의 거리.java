import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<int[]>[] tree = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++)
			tree[i] = new ArrayList<>();
		
		for(int i = 0; i < n -1; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			tree[f].add(new int[] {t, d});
			tree[t].add(new int[] {f, d});
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[] vis = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			q.clear();
			q.offer(new int[] {f, 0});
			
			Arrays.fill(vis, false);
			vis[f] = true;
			while(!q.isEmpty()) {
				int[] v = q.poll();
				
				if(v[0] == t) {
					sb.append(v[1] + "\n");
					break;
				}
				
				for(int[] nv : tree[v[0]]) {
					if(vis[nv[0]]) continue;
					
					vis[nv[0]] = true;
					q.offer(new int[] {nv[0], nv[1] + v[1]});
					
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
}