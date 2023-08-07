import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++)
				list.add(Integer.parseInt(st.nextToken()));

			while (n > 0) {
				int maxidx = list.indexOf(Collections.max(list));
				int minidx = list.indexOf(Collections.min(list));

				list.set(maxidx, list.get(maxidx) - 1);
				list.set(minidx, list.get(minidx) + 1);

				n--;
			}
			int res = Collections.max(list) - Collections.min(list);
			
			
			System.out.printf("#%d %d\n",test_case, res);

		}
	}
}
