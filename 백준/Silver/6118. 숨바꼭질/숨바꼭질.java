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

		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		boolean[] vis = new boolean[n + 1];
		Queue<int[]> q = new ArrayDeque<>();
		int[] dist = new int[n + 1];
		int max = 0;
		q.offer(new int[] {1,0});
		vis[1] = true;

		while (!q.isEmpty()) {
			int[] cv = q.poll();
			dist[cv[0]] = cv[1];
			if(max < cv[1])
				max = cv[1];
			
			for (int nv : graph[cv[0]]) {
				if (vis[nv])
					continue;
				vis[nv] = true;
				q.offer(new int[] {nv, cv[1]+1});
			}
		}

		int cnt = 0, hide = 0;
		for (int i = 1; i < n + 1; i++) {
			if (dist[i] == max) {
				cnt++;
				if(hide == 0)
					hide = i;
			}
		}
		System.out.println(hide + " " + max + " " + cnt);

	}

}
