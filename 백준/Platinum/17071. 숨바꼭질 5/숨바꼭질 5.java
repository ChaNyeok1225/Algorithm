import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dx = {-1, 1, 0};
		
		int[][] dist = new int[2][500005];
		int[] sis = new int[500005];
		

		Arrays.fill(dist[0], -1);
		Arrays.fill(dist[1], -1);
		Arrays.fill(sis, -1);
		
		int sum = 0;
		for(int i = k; i <= 500000; i +=++sum) {
			sis[i] = sum;
		}
		
		Queue<int []> q = new ArrayDeque<>();
		
		q.offer(new int[] {n, 0});
		dist[0][n] = 0;
		
		int time = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			if(dist[p[1]][p[0]] <= sis[p[0]]) {
				if((sis[p[0]] - dist[p[1]][p[0]]) % 2 == 0) {
					time = Math.min(time, sis[p[0]]);
				}
			}
			
			dx[2] = p[0];
			for(int dir = 0; dir < 3; dir++) {
				int np = p[0] + dx[dir];
				
				if(np < 0 || 500000 < np)
					continue;
				
				if(dist[p[1]^1][np] >= 0)
					continue;
				
				dist[p[1]^1][np] = dist[p[1]][p[0]] + 1;
				q.offer(new int[] {np, p[1]^1});
			}
		}
		
		if(time == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(time);
		
	}

}
