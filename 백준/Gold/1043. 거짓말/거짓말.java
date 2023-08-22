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

		ArrayList<Integer> truth = new ArrayList<>();
		boolean[] tp = new boolean[n + 1];
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < k; i++)
			truth.add(Integer.parseInt(st.nextToken()));

		ArrayList<Integer>[] party = new ArrayList[m];
		boolean[][] graph = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			party[i].add(a);
			for (int j = 1; j < k; j++) {
				int b = Integer.parseInt(st.nextToken());
				party[i].add(b);

				graph[a][b] = true;
				graph[b][a] = true;
				a = b;
			}
		}

		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] vis = new boolean[n + 1];
		for (int i = 0; i < truth.size(); i++) {
			Arrays.fill(vis, false);

			q.offer(truth.get(i));
			vis[truth.get(i)] = true;

			while (!q.isEmpty()) {
				int cv = q.poll();
				tp[cv] = true;

				for (int j = 1; j < n + 1; j++) {
					if (graph[cv][j] && !vis[j]) {
						q.offer(j);
						vis[j] = true;
					}
				}
			}
		}
		
//		System.out.println(truth);
//		System.out.println(Arrays.toString(tp));
		int cnt = 0;
		L: for (int i = 0; i < m; i++) {
			for (int j = 0; j < party[i].size(); j++) {
				if (tp[party[i].get(j)])
					continue L;
			}
			cnt++;
		}

		System.out.println(cnt);
	}

}
