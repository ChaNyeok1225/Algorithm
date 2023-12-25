import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long x = Integer.parseInt(st.nextToken());
		long y = Integer.parseInt(st.nextToken());
		long z = 100 * y / x;
		long start = 1, end = x;
		long mid, ans = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;

			long val = 100 * (y + mid) / (x + mid);
			if(val > z) {
				end = mid - 1;
				ans = mid;
			} else
				start = mid + 1;
		}
		
		System.out.println(ans);

	}
}