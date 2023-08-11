import java.util.*;
import java.io.*;

public class Main {

	static int end, max;
	static int[][] meeting;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());

		meeting = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
			meeting[i][2] = Integer.parseInt(st.nextToken());

			if (end < meeting[i][0])
				end = meeting[i][0];

		}

		Arrays.sort(meeting, (int[] a1, int[] a2) -> {
			return a1[1] - a2[1];
		});
//
//		int idx = 0;
//		for(int i = idx; meeting[idx][1] >= meeting[i][0]; i++) {
//			System.out.println(i + 1 + " " + meeting[i][1] + " " + meeting[i][2]);
//		}
		
		
		dfs(0, 0, 0);
		
		System.out.println(max);

		////////////////////////////////////////////////////
		br.close();

	}

	public static void dfs(int idx, int st, int sum) {
		
		if (st > end) {
			if (max < sum)
				max = sum;
			return;
		}

		for(int i = idx; i < meeting.length; i++) {
			if(meeting[i][0] < st) continue;
			dfs(i + 1, meeting[i][1], sum + meeting[i][2]);
		}

	}

}
