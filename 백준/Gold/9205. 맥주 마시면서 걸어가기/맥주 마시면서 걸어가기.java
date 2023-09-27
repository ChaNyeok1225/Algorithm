import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[n+2][n+2];
			
			for(int i = 0; i < n +2 ;i++)
				for(int j = 0; j < n + 2; j++) {
					if(i == j) continue;
					graph[i][j] = 100_000_000;
				}
			
			int[][] pos = new int[n+2][2];
			for(int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < n+2; i++) {
				int[] p1 = pos[i];
				for(int j = 0; j < n +2; j++) {
					int[]p2 = pos[j];
					int dist = Math.abs(p1[0]-p2[0]) + Math.abs(p1[1] - p2[1]);
					graph[i][j] = dist;
					
				}
			}
			
			Queue<Integer> q = new ArrayDeque<Integer>();
			boolean[] vis = new boolean[n+2];
			q.offer(0);
			vis[0] = true;
			
			boolean flag = false;
			while(!q.isEmpty()) {
				int c =  q.poll();
				
				if(c == n + 1) {
					flag = true;
					break;
				}
				
				
				for(int i = 0; i < n + 2; i++) {
					if(vis[i] || graph[c][i] > 1000) continue;
					vis[i] = true;
					q.offer(i);
				}
			}
			
			if(flag)
				sb.append("happy");
			else
				sb.append("sad");
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
}