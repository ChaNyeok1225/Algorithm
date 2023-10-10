import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());

		char[] p = new char[n];
		char[] s = new char[2*n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			p[i] = st.nextToken().charAt(0);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			s[i] = s[i+n] = st.nextToken().charAt(0);

		int[] f = new int[n];

		int j = 0;
		for (int i = 1; i < n; i++) {
			while (j > 0 && p[i] != p[j])
				j = f[j - 1];
			if (p[i] == p[j])
				f[i] = ++j;
		}

		int cnt = 0;

		j = 0;

		for (int i = 0; i < 2*n - 1; i++) {
			while (j > 0 && s[i] != p[j])
				j = f[j - 1];
			if (s[i] == p[j])
				++j;

			if (j == n) {
				cnt++;
				j = f[j - 1];
			}
		}

		int d = gcd(n, cnt);

		System.out.println(cnt / d + "/" + n / d);

	}

	static int gcd(int a, int b) {

		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}

		return a;
	}

}