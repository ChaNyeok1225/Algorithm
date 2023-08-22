import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] parent;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			parent = new int[n + 1];

			make(n);
			sb.setLength(0);
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int inst = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(inst == 0) {
					union(a,b);
				}else {
					if(find(a) == find(b))
						sb.append("1");
					else
						sb.append("0");
				}
				
			}
			

			System.out.printf("#%d %s\n", tc,sb);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return;

		parent[b] = a;
	}

	static int find(int idx) {
		if (idx == parent[idx])
			return idx;
		return parent[idx] = find(parent[idx]);
	}

	static void make(int n) {
		for (int i = 1; i < n + 1; i++)
			parent[i] = i;
	}

}