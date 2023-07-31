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

	static int n;
	static int m;
	static int[] arr;
	static int sum = 0;
	static boolean[] vis;
	static int res = 0;

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		vis = new boolean[n];

		func(0);

		System.out.println(res);

		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int idx) {
		int i;
		for (i = idx; i < n; i++) {
			if (vis[i])
				continue;
			vis[i] = true;
//			System.out.println(Arrays.toString(vis));
			sum += arr[i];
			if (sum == m) {
				res++;
			}
			func(i + 1);
			sum -= arr[i];
			vis[i] = false;
		}

	}

}
