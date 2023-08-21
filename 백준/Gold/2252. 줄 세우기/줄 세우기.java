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
		boolean[] stand = new boolean[n + 1];

		ArrayList<Integer>[] rel = new ArrayList[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			indegree[b]++;
			if (rel[a] == null)
				rel[a] = new ArrayList<>();
			rel[a].add(b);
		}

		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i < n + 1; i++)
			if (indegree[i] == 0) {
				q.offer(i);
				stand[i] = true;
			}

		while (!q.isEmpty()) {
			int num = q.poll();
			sb.append(num + " ");

			if (rel[num] != null) {
				for (int x : rel[num])
					indegree[x]--;
				
				
				for (int i = 1; i < n + 1; i++) {
					if (stand[i])
						continue;
					if (indegree[i] == 0) {
						q.offer(i);
						stand[i] = true;
					}
				}
			}


		}
		System.out.println(sb);

	}

}
