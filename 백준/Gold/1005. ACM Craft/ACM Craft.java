import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] inDgree = new int[n+1];
			ArrayList<Integer>[] graph = new ArrayList[n+1];
			for(int i = 1; i < n + 1; i ++)
				graph[i] = new ArrayList<>();
			
			int[] D = new int[n+1];
			int[] spent = new int[n+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < n + 1; i++) 
				spent[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				inDgree[b]++;
			}
			
			int win = Integer.parseInt(br.readLine());
			
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] vis = new boolean[n+1];
			for(int i = 1; i < n +1; i++) {
				if(inDgree[i] == 0) {
					D[i] = spent[i];
					vis[i] = true;
					q.offer(i);
				}
			}
			
			while(!q.isEmpty()) {
				int cv = q.poll();
				
				if(cv == win)
					break;
				
				for(int nv : graph[cv]) {
					if(vis[nv]) continue;
					
					inDgree[nv]--;
					D[nv] = Math.max(D[nv], D[cv] + spent[nv]);
					if(inDgree[nv] == 0) {
						vis[nv] = true;
						q.offer(nv);
					}
				}
			}
			
			sb.append(D[win] +"\n");
			
		}
		System.out.println(sb);
		
	}
}