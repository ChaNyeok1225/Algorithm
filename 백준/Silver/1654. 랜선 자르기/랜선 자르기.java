import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] lan = new int[k];
		for (int i = 0; i < k; i++)
			lan[i] = Integer.parseInt(br.readLine());

		long min = 1;
		long max = 0x7fffffff;
		while (min < max) {
			long mid = (min + max + 1) / 2;
			long sum = 0;
			for (int i = 0; i < k; i++)
				sum += lan[i] / mid;

			if (sum >= n) {
				min = mid;
			} else {
				max = mid - 1;
			}
		}

		System.out.println(min);

	}

}
