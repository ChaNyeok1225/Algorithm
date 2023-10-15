import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static boolean flag, vis[];
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {

		int tc = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			vis = new boolean[n + 1];
			graph = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());

				graph[f].add(t);
				graph[t].add(f);
			}

			int cnt = 0;

			for (int i = 1; i < n + 1; i++) {
				if (vis[i])
					continue;
				flag = true;
				
				dfs(i, 0);
				
				if(flag)
					cnt++;
				
			}

			switch (cnt) {
			case 0:
				sb.append(String.format("Case %d: No trees.", tc));
				break;

			case 1:
				sb.append(String.format("Case %d: There is one tree.", tc));
				break;

			default:
				sb.append(String.format("Case %d: A forest of %d trees.", tc, cnt));
				break;
			}
			sb.append("\n");

			tc++;
		}
		System.out.println(sb);

	}
	
	static void dfs(int cur, int parent) {
		vis[cur] = true;
		
		for(int nxt : graph[cur]) {
			if(nxt == parent) continue;
			
			if(vis[nxt]) {
				flag = false;
				continue;
			}
			
			dfs(nxt, cur);
		}
	}

}