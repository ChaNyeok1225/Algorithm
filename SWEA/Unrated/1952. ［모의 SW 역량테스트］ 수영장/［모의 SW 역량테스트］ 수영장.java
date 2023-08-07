import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			int[] price = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				price[i] = Integer.parseInt(st.nextToken());

			int[] use = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < 13; i++)
				use[i] = Integer.parseInt(st.nextToken());

			int[] D = new int[13];

			for (int i = 1; i < 13; i++) {
				int d = use[i] * price[0];
				int m = price[1];

				int min = D[i - 1] + Math.min(d, m);
				if (2 < i)
					min = Math.min(min, D[i - 3] + price[2]);

				D[i] = min;
			}

			int res = Math.min(D[12], price[3]);

			System.out.printf("#%d %d\n", tc, res);

		}

		System.out.print(sb);
		////////////////////////////////////////////////////
		br.close();

	}

}
