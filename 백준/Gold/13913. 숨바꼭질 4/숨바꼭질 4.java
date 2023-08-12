import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] D = new int[100005][2];
		int[] dx = {-1,1,0};
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		q.offer(n);
		D[n][0] = 1;
		while(!q.isEmpty()) {
			int p = q.poll();
			
			if(p==k)
				break;
			
			
			dx[2] = p;
			
			for(int dir = 0; dir < 3; dir++) {
				int np = p + dx[dir];
				
				if(np < 0 || D.length <= np)
					continue;
				
				if(D[np][0] != 0)
					continue;
				
				D[np][0] = D[p][0] + 1;
				D[np][1] = p;
				q.add(np);
			}
		}
		
		sb.append(D[k][0]-1 + "\n");
		q.clear();
		q.offer(k);
		while(k != n) {
			q.offerFirst(D[k][1]);
			k = D[k][1];
		}
		for(int p : q)
			sb.append(p + " ");
		System.out.println(sb);
		
	}

}
