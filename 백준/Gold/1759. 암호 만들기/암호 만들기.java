import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[] arr;
	static char[] ch;

	static int n;
	static int m;

	static Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n];
		ch = new char[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++)
			ch[i] = st.nextToken().charAt(0);

		Arrays.sort(ch);

		func(0, 0);
		System.out.println(sb);

	}

	public static void func(int idx, int r) {
		if (r == n) {
			int cnt1 = 0, cnt2 = 0;
			for (int i = 0; i < n; i++) {
				if (set.contains(arr[i]))
					cnt1++;
				else
					cnt2++;
			}

			if (cnt1 > 0 && cnt2 > 1) {
				sb.append(new String(arr));
				sb.append("\n");
			}
			return;
		}

		for (int i = idx; i < m; i++) {
			arr[r] = ch[i];
			func(i + 1, r + 1);
		}

	}
}
