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

		int[] tree = new int[n];
		int start = 0, end = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (end < tree[i])
				end = tree[i];
		}
		int max = 0;
		int mid = 0, pmid = 0;
		while (start <= end) {
			mid = (start + end + 1) / 2;
			long totallen = 0;

			for (int i = 0; i < n; i++) {
				totallen += (mid < tree[i]) ? tree[i] - mid : 0;
			}

			if (totallen < m) {
				end = mid - 1;
			} else if (totallen >= m) {
				if (mid > max)
					max = mid;
				start = mid + 1;
			}
//			System.out.println(mid);
		}

		System.out.println(max);

	}
}
