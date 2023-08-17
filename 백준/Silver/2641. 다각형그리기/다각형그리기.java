import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int[] dir = new int[n];
		int[] rdir = new int[n];

		int[] r = { 0, 3, 4, 1, 2 };

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			dir[i] = Integer.parseInt(st.nextToken());
		for (int i = n - 1; i >= 0; i--)
			rdir[n - 1 - i] = r[dir[i]];

		int cnt = 0;
		int[] tmp = new int[n];

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				tmp[j] = Integer.parseInt(st.nextToken());

			boolean flag = false;
			for (int j = 0; j < n && !flag; j++) {
				if (tmp[0] == dir[j]) {
					for (int l = 0; l < n; l++) {
						if (tmp[l] != dir[(j + l) % n])
							break;
						if (l == n - 1)
							flag = true;
					}

				}
				if (tmp[0] == rdir[j]) {
					for (int l = 0; l < n; l++) {
						if (tmp[l] != rdir[(j + l) % n])
							break;
						if (l == n - 1)
							flag = true;
					}
				}

			}

			if (flag) {
				cnt++;
				for (int j = 0; j < n; j++)
					sb.append(tmp[j] + " ");
				sb.append("\n");
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb);

	}

}
