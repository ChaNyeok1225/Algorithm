import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(func(n, r, c));

		////////////////////////////////////////////////////
		br.close();
	}

	static long func(int k, int a, int b) {
		if (k == 0)
			return 0;

		int half = 1 << k - 1;

		if (a < half && b < half)
			return func(k - 1, a, b);
		else if (a < half && b >= half)
			return half * half + func(k - 1, a, b - half);
		else if (a >= half && b < half)
			return half * half * 2 + func(k - 1, a - half, b);
		else
			return half * half * 3 + func(k - 1, a - half, b - half);

	}

}
