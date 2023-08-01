import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int[][] arr;
	static int max;

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		func(0, 0);

		System.out.println(max);
	}

	public static void func(int idx, int cnt) {

		if(idx == n) {
//			System.out.println(cnt);
			
			if(max < cnt)
				max = cnt;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (arr[idx][0] <= 0 || cnt == n - 1) {
				func(idx + 1, cnt);
				return;
			}
			else {
				if (idx == i || arr[i][0] <= 0)
					continue;

				arr[idx][0] -= arr[i][1];
				arr[i][0] -= arr[idx][1];
				if (arr[idx][0] <= 0) cnt++;
				if (arr[i][0] <= 0)	cnt++;
				
				func(idx + 1, cnt);

				if (arr[i][0] <= 0) cnt--;
				if (arr[idx][0] <= 0) cnt--;
				arr[idx][0] += arr[i][1];
				arr[i][0] += arr[idx][1];
			
			}
		}
	}
}
