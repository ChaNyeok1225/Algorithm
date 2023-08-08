import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		for (int tc = 1; tc < 11; tc++) {

			int n = Integer.parseInt(br.readLine());

			boolean[] tree = new boolean[n + 1];

			for (int i = 1; i < n + 1; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = chk(st.nextToken());
			}

			int cnt = 0;
			int idx = n;
			while (idx > 0) {
				if(!(tree[idx]) && !(tree[idx-1]))
					if (tree[idx / 2]) {
						tree[idx / 2] = false;
						cnt+=2;
					}
					else
						break;
				idx -= 2;
			}

			
			System.out.printf("#%d %d\n", tc, n-1==cnt? 1:0);
		}
	}

	public static boolean chk(String s) {
		return s.equals("*") || s.equals("+") || s.equals("-") || s.equals("/");
	}
}
