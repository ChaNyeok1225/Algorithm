import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[1] == b[1])
				return a[0] - b[0];
			return a[1] - b[1];
		});

		int[] tt = new int[400000];
		Arrays.fill(tt, -1);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int rt = Integer.parseInt(st.nextToken());
			int at = Integer.parseInt(st.nextToken());
			tt[rt] = at;
			pq.offer(new int[] { rt, at });
		}

		int time = 1;
		int res = 0;

		L: while (!pq.isEmpty()) {

			int t = tt[time];
			if (t == -1 || t > time) {
				if (pq.peek()[1] <= time) {
					int[] p = pq.poll();

					while (tt[p[0]] == -1) {
						if (pq.isEmpty())
							break L;
						p = pq.poll();
					}
				
					if (res < time - p[1])
						res = time - p[1];
					tt[p[0]] = -1;
				}
			} else {
				if (res < time - tt[time])
					res = time - tt[time];
				tt[time] = -1;

			}
			time++;
		}

		System.out.println(res);
	}

}