import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[][] trucks = new int[n][2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks[i][0] = Integer.parseInt(st.nextToken());
			trucks[i][1] = w;
		}

		LinkedList<int[]> q = new LinkedList<>();
		int idx = 0;
		int day = 0;
		while (idx == 0 || !q.isEmpty()) {
			
//			for(int i = 0; i < q.size(); i++)
//				System.out.print(Arrays.toString(q.get(i)) + " ");
//			System.out.println();
			
			int cl = 0;
			for (int i = q.size() - 1; i >= 0; i--) {
				q.get(i)[1]--;

				if (q.get(i)[1] <= 0)
					q.pollLast();
				else {
					if (q.get(i)[1] >= 0)
						cl += q.get(i)[0];
				}
			}

			if (idx < n) {
				if ((l - cl) >= trucks[idx][0])
					q.addFirst(trucks[idx++]);
			}
			day++;
		}

		System.out.println(day);

	}

}
