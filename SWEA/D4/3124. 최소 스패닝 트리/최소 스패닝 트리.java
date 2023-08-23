import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] parent;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			parent = new int[v + 1];
			make(v);

			Edge[] edges = new Edge[e];
			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				edges[i] = new Edge(v1, v2, w);
			}
			Arrays.sort(edges, (a, b) -> a.w - b.w);

			int cnt = 0;
			long ans = 0;

			for (int i = 0; i < e; i++) {
				Edge edge = edges[i];

				if (union(edge.v1, edge.v2)) {
					cnt++;
					ans += edge.w;
				}
				if(cnt == v-1)
					break;
			}

			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		parent[b] = a;
		return true;
	}

	static void make(int n) {
		for (int i = 0; i < n + 1; i++)
			parent[i] = i;
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = find(parent[a]);
	}

	static class Edge {
		int v1;
		int v2;
		int w;

		public Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}

	}

}
