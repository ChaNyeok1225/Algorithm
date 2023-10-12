import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static class Tri {
		boolean flag;
		Tri[] nxt = new Tri[26];
	}

	public static void main(String[] args) throws Exception {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Tri tri = new Tri();

		for (int i = 0; i < n; i++) {
			char[] str = br.readLine().toCharArray();

			Tri node = tri;
			for (int j = 0; j < str.length; j++) {
				if (node.nxt[str[j] - 'a'] == null)
					node.nxt[str[j] - 'a'] = new Tri();
				node = node.nxt[str[j] - 'a'];
				node.flag = true;
			}
		}

		int cnt = 0;
		loop : for (int i = 0; i < m; i++) {
			char[] str = br.readLine().toCharArray();
			
			Tri node = tri;
			for (int j = 0; j < str.length; j++) {
				if (node.nxt[str[j] - 'a'] == null)
					continue loop;
				node = node.nxt[str[j] - 'a'];
			}
			cnt++;
		}
		System.out.println(cnt);

	}

}