import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static ArrayList<Integer>[] graph;
	static int ans = 0;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (graph[a] == null)
				graph[a] = new ArrayList<>();
			if (graph[b] == null)
				graph[b] = new ArrayList<>();

			graph[a].add(b);
			graph[b].add(a);
		}
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i++) 
			dfs(i, 0, vis);
		
		
		
		System.out.println(ans);

	}

	static void dfs(int idx, int cnt, boolean[] vis) {
		if (ans == 1)
			return;

		vis[idx] = true;
		if (cnt == 4) {
			ans = 1;
			return;
		}

		if (graph[idx] != null) {
			for (int nv : graph[idx]) {
				if (vis[nv])
					continue;
				dfs(nv, cnt+1, vis);
			}
		}
		
		vis[idx] = false;

	}

}
