import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;

	static int[] arr;
	static boolean[] vis;
	static int[] nums;

	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		nums = new int[n];
		vis = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(nums);

		func(0,0);

		System.out.print(sb);

	}

	public static void func(int idx, int k) {
		if (k == m) {
			String s = Arrays.toString(arr);
			if (!set.contains(s)) {
				for(int i = 0; i < m; i++)
					sb.append(arr[i] + " ");
				sb.append("\n");
				set.add(Arrays.toString(arr));
			}
			return;
		}

		for (int i = idx; i < n; i++) {
			if (vis[i])
				continue;
			vis[i] = true;
			arr[k] = nums[i];
			func(i+1, k + 1);
			vis[i] = false;
		}

	}
}
