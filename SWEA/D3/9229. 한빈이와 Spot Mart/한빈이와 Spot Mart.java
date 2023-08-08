import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, m;
	static int max; // 최댓값을 받을 변수
	static int[] sn;// 과자 무게를 넣을 배열

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			max = -1; // 경우의 수 없을 경우 -1 반환
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			sn = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) // 과자 무게 입력
				sn[i] = Integer.parseInt(st.nextToken());

			dfs(0, 0, 0); // 0개, 0번 인덱스부터, 합 0

			System.out.printf("#%d %d\n", tc, max); // 출력
		}
	}

	static void dfs(int cnt, int idx, int sum) {
		
		// 모든 과자의 무게는 양수이므로 m보다 sum이 커지면 return
		if (sum > m) 
			return;
		
		// 선택한 과자가 2개이고 max보다 크면 저장
		if (cnt == 2) {
			if (sum > max)
				max = sum;
			return;
		}

		// n 개 중 중복없이 2개 뽑음
		for (int i = idx; i < n; i++) {
			dfs(cnt + 1, i + 1, sum + sn[i]);
		}

	}

}
