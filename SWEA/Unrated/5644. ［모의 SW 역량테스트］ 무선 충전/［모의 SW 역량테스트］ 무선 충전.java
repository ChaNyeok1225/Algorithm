import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = {0, -1, 0, 1, 0 }, dy = {0, 0, 1, 0, -1 };
	static int[][] AP;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());

			int[] mvA = new int[m + 1];
			int[] mvB = new int[m + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				mvA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++)
				mvB[i] = Integer.parseInt(st.nextToken());

			AP = new int[a][4];

			for (int i = 0; i < a; i++) {
				st = new StringTokenizer(br.readLine());
				AP[i][1] = Integer.parseInt(st.nextToken());
				AP[i][0] = Integer.parseInt(st.nextToken());
				AP[i][2] = Integer.parseInt(st.nextToken());
				AP[i][3] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(AP, (o1, o2) -> o2[3] - o1[3]);

			int[] A = { 1, 1 }, B = { 10, 10 };

			int ans = 0;
			for (int i = 0; i <= m; i++) {
				List<Integer> aap = new ArrayList<Integer>();
				List<Integer> bap = new ArrayList<Integer>();

				for (int j = 0; j < a; j++) {
					if (getD(A[0], A[1], AP[j][0], AP[j][1]) <= AP[j][2])
						aap.add(j);
					if (getD(B[0], B[1], AP[j][0], AP[j][1]) <= AP[j][2])
						bap.add(j);
				}

				ans += charge(aap, bap);
				
				A[0] += dx[mvA[i]];
				A[1] += dy[mvA[i]];
				B[0] += dx[mvB[i]];
				B[1] += dy[mvB[i]];
			}
			
			sb.append(String.format("#%d %d\n", tc,ans));

		}
		System.out.print(sb);

	}

	static int charge(List<Integer> aap, List<Integer> bap) {

		if (aap.size() == 0 && bap.size() == 0)
			return 0;

		if (bap.size() == 0)
			return AP[aap.get(0)][3];

		if (aap.size() == 0)
			return AP[bap.get(0)][3];

		int sum = 0;

		for (int i : aap) {
			for (int j : bap) {
				if (i == j)
					sum = sum > AP[i][3] ? sum : AP[i][3];
				else {
					sum = sum > AP[i][3] + AP[j][3] ? sum : AP[i][3] + AP[j][3];
				}
			}
		}

		return sum;
	}

	static int getD(int sx, int sy, int ex, int ey) {
		return Math.abs(sx - ex) + Math.abs(sy - ey);
	}

}