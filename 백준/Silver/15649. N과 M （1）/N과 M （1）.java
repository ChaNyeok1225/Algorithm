import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;

	static boolean[] vis;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		///////////////////// 구현부//////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		vis = new boolean[n + 1];
		arr = new int[n];
		func(0);

		System.out.println(sb);
	}

	public static void func(int cnt) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i < n + 1; i++) {
				if(vis[i]) continue;
				vis[i] = true;
				arr[cnt] = i;
				func(cnt + 1);
				vis[i] = false;
			}
		}

	}

}
