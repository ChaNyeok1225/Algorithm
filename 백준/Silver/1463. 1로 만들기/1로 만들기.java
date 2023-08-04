import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		int x = Integer.parseInt(br.readLine());
		int[] cnt = new int[x + 1];
		Queue<Integer> q = new ArrayDeque<>();

		q.add(x);

		while (!q.isEmpty()) {
			int p = q.poll();
			if(p == 1)
				break;
			
			if (p % 2 == 0 && cnt[p / 2] == 0) {
				cnt[p / 2] = cnt[p] + 1;
				q.add(p / 2);
			}

			if (p % 3 == 0 && cnt[p / 3] == 0) {
				cnt[p / 3] = cnt[p] + 1;
				q.add(p / 3);
			}

			if (p-1 >= 0 && cnt[p - 1] == 0) {
				cnt[p - 1] = cnt[p] + 1;
				q.add(p - 1);
			}

		}
		
		System.out.println(cnt[1]);

	}

}
