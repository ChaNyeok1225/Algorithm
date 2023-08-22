import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		for(int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[b].add(a);
		}
		
		int[] light = new int[n+1];
		int[] heavy = new int[n+1];
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		boolean[][] vis = new boolean[n+1][n+1];
		for(int i = 1; i < n +1; i++) {
			q.offer(i);
			vis[i][i] = true;
			
			while(!q.isEmpty()) {
				int cv= q.poll();
				light[i]++;
				
				for(int nv : graph[cv]) {
					if(vis[i][nv]) continue;
					vis[i][nv] = true;
					q.offer(nv);
					heavy[nv]++;
				}
			}
		}
		int cnt = 0;
		for(int i = 1; i < n +1; i++) 
			if(light[i]-1 > n/2 || heavy[i] > n/2) {
				cnt++;
			}
		System.out.println(cnt);
			
		
	}

}
