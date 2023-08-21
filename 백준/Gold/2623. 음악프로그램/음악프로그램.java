import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] indegree = new int[n + 1];
		ArrayList<Integer>[] graph = new ArrayList[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			int a = Integer.parseInt(st.nextToken());
			for(int j = 1; j < k; j++) {
				int b= Integer.parseInt(st.nextToken());
				indegree[b]++;
				if(graph[a] == null)
					graph[a] = new ArrayList<>();
				graph[a].add(b);
				a = b;
			}
		}

		Queue<Integer> q = new ArrayDeque<Integer>();
		int cnt = 0;
		for (int i = 1; i < n + 1; i++)
			if (indegree[i] == 0) {
				q.offer(i);
				cnt++;
			}

		while (!q.isEmpty()) {
			int num = q.poll();

			sb.append(num + "\n");

			if (graph[num] != null) {
				for (int x : graph[num]) {
					indegree[x]--;
					if (indegree[x] == 0) {
						q.offer(x);
						cnt++;
					}
				}
			}
		}

		if(cnt != n)
			System.out.println(0);
		else
			System.out.println(sb);

	}

}
