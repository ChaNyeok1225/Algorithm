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
		for(int i = 1; i < n+1; i++)
			graph[i] = new ArrayList<>();
		
		int[] inDegree =new int[n+1];
		int[] needs = new int[n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[f].add(new int[] {t, w});
		}
		
		Queue<Integer> chkIn = new ArrayDeque<Integer>();
		chkIn.offer(n);
		
		while(!chkIn.isEmpty()) {
			int v = chkIn.poll();
			
			for(int[] nv : graph[v]) {
				if(inDegree[nv[0]] == 0)
					chkIn.offer(nv[0]);
				inDegree[nv[0]]++;
			}
		}
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		q.offer(new int[] {n, 1});
		
		while(!q.isEmpty()) {
			int[] cv = q.poll();
			for(int[] nv : graph[cv[0]]) {
				inDegree[nv[0]]--;
				needs[nv[0]] += nv[1] * cv[1];
				
				if(inDegree[nv[0]] == 0) {
					q.offer(new int[] {nv[0], needs[nv[0]]});
				}
			}
		}
		
		for(int i = 1; i < n + 1; i++) 
			if(graph[i].isEmpty()) 
				sb.append(i + " " + needs[i] +"\n");
		
		System.out.print(sb);
		
		
	}
	
}