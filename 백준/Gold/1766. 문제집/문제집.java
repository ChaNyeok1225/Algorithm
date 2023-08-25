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
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for(int i = 1; i < n +1; i++)
			graph[i] = new ArrayList<>();
		int[] inDegree = new int[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			inDegree[b]++;
			graph[a].add(b);
		}
		boolean[] vis = new boolean[n+1];
		PriorityQueue<Integer> q = new PriorityQueue<>() ;
		for(int i = 1; i < n+1; i++)
			if(inDegree[i] == 0) {
				q.offer(i);
				vis[i] = true;
			}
		
		while(!q.isEmpty()) {
			int cp = q.poll();
			
			sb.append(cp + " ");
			
			for(int np : graph[cp]) {
				if(vis[np]) continue;
				inDegree[np]--;
				if(inDegree[np]==0) {
					vis[np] = true;
					q.offer(np);
				}
			}
		}
		
		System.out.println(sb);
	}

}
