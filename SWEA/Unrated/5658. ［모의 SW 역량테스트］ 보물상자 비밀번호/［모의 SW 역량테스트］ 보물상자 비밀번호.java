import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int l = n / 4;

			TreeSet<Integer> ts = new TreeSet<>((a, b) -> b - a);
			ArrayList<Character> list = new ArrayList<>();

			char[] c = br.readLine().trim().toCharArray();
			for (int i = 0; i < n; i++)
				list.add(c[i]);

			StringBuilder str = new StringBuilder();

			for (int r = 0; r < l; r++) {
				for (int i = 0; i < 4; i++) {
					str.setLength(0);
					for (int j = 0; j < l; j++) {
						str.append(list.get(i * l + j));
					}
					ts.add(Integer.parseInt(str.toString(), 16));
				}
				Collections.rotate(list, 1);
			}

			int cnt = 0;
			for (int v : ts) {
				cnt++;
				if (cnt == k) {
					sb.append("#").append(tc).append(" ").append(v).append("\n");
					break;
				}
			}

		}
		System.out.print(sb);

	}

}
