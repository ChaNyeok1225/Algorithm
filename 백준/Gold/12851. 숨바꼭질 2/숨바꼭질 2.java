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

		int MX = 200000;
		
		int[][] D = new int[MX][2];
		Queue<Integer> q = new ArrayDeque<>();
		
		D[n][0] = D[n][1] = 1;
		q.offer(n);

		int[] nxt = { 1, -1, 0 };
		int cnt = 0, depth = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int p = q.poll();

//			System.out.println(p[0] + " " + p[1]);
			
			if(D[p][0] > depth)
				break;
			
			if(p == k) 
				depth = D[p][0];
			
			
			nxt[2] = p;

			for (int dir = 0; dir < 3; dir++) {
				int np = p + nxt[dir];

				if (np < 0 || MX <= np)
					continue;
				
				if(D[np][0] == D[p][0] + 1) {
					D[np][1] += D[p][1];
					continue;
				} else if (D[np][0] > 0)
					continue;
				
				D[np][0] = D[p][0] + 1;
				D[np][1] += D[p][1];
				q.offer(np);
				
			}
		}

		System.out.println(depth - 1);
		System.out.println(D[k][1]);
		
	}

}
