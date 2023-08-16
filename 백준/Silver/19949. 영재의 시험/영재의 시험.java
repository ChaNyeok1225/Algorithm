import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] ans;
	static int res;

	public static void main(String[] args) throws IOException {

		ans = new int[10];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++)
			ans[i] = Integer.parseInt(st.nextToken());

		backt(0, 0, 0, 0);

		System.out.println(res);
	}

	private static void backt(int idx, int prev, int cnt, int score) {

		if (idx == 10) {
			if(score > 4)
				res++;
			return;
		}

		for (int i = 1; i < 6; i++) {
			if (prev == i) {
				if (cnt < 2)
					backt(idx + 1, i, cnt + 1, score + (ans[idx] == i ? 1 : 0));
				continue;
			}
			backt(idx + 1, i, 1, score + (ans[idx] == i ? 1 : 0));
		}
		
	}

}
