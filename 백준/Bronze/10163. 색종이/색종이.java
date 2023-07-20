import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		byte[][] page = new byte[1001][1001];

		int x, y, xd, yd;
		for (int t = 1; t < n + 1; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			xd = Integer.parseInt(st.nextToken());
			yd = Integer.parseInt(st.nextToken());

			for (int i = x; i < x + xd; i++) {
				for (int j = y; j < y + yd; j++) {
					page[i][j] = (byte) t;
				}
			}
		}

		int[] cnt = new int[n];
		for (int t = 1; t < n + 1; t++) {
			int c = 0;
			for (int i = 0; i < 1001; i++) {
				for (int j = 0; j < 1001; j++) {
					if(page[i][j] == t)
						c++;
				}
			}
			cnt[t-1] = c;
		}

		for(int i = 0; i < n; i++)
			System.out.println(cnt[i]);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
