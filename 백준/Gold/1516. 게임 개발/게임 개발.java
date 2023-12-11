import java.io.*;
import java.util.*;

import sun.net.www.content.text.plain;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n+1];
		int[] res = new int[n+1];
		int[] in = new int[n+1];
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			
			while(true) {
				int v = Integer.parseInt(st.nextToken());
				if(v == -1)
					break;
				graph[v].add(i);
				in[i]++;
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(
				(a,b) -> a[1] - b[1]
		);
		
		for(int i = 1; i < n + 1; i++)
			if(in[i] == 0)
				q.offer(new int[] {i, time[i]});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			res[cur[0]] = cur[1];
			
			for(int nv : graph[cur[0]]) {
				in[nv]--;
				if(in[nv] == 0) {
					q.offer(new int[] {nv, cur[1] + time[nv]});
				}
			}
		}
		
		for(int i = 1; i < n + 1; i++)
			sb.append(res[i]).append("\n");
		
		System.out.println(sb);
		
		
	}
	
}