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
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		ArrayList<Integer>[] hiper = new ArrayList[m];

		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < m; i++)
			hiper[i] = new ArrayList<>();

		int a;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < k; j++) {
				a = Integer.parseInt(st.nextToken());

				hiper[i].add(a);
				graph[a].add(i);
			}
		}

		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[] visS = new boolean[n + 1];
		boolean[] visH = new boolean[m];

		q.offer(new int[] { 1, 1, 0 });
		visS[1] = true;
		int ans = -1;
		while (!q.isEmpty()) {
			int[] cv = q.poll();

			if (cv[0] == n && cv[2] == 0) {
				ans = cv[1];
				break;
			}

			if (cv[2] == 0) {
				for (int nh : graph[cv[0]]) {
					if (visH[nh])
						continue;
					visH[nh] = true;
					q.offer(new int[] { nh, cv[1], 1 });
				}
			} else if (cv[2] == 1) {
				for (int nv : hiper[cv[0]]) {
					if (visS[nv])
						continue;
					visS[nv] = true;
					q.offer(new int[] { nv, cv[1] + 1, 0 });
				}
			}
		}

		System.out.println(ans);
	}

}
