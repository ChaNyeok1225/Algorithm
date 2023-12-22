import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] len = new int[n];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			len[i] = Integer.parseInt(st.nextToken());
			max = max > len[i] ? max : len[i];
		}

		int start = 1;
		int end = max;
		int mid = 0;
		int ans = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				cnt += len[i] / mid;
			}

			if (cnt < m)
				end = mid - 1;
			else {
				start = mid + 1;
				ans = mid;
			}
		}

		System.out.println(ans);

	}
}