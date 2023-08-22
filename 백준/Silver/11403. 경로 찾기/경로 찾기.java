import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int[][] graph = new int[n][n];
		int[][] vis = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {

			q.offer(i);

			while (!q.isEmpty()) {
				int cv = q.poll();

				for (int j = 0; j < n; j++) {
					if (graph[cv][j] == 1) {
						if (vis[i][j] == 1)
							continue;
						vis[i][j] = 1;
						q.offer(j);
					}
				}
			}

		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				sb.append(vis[i][j]+" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
