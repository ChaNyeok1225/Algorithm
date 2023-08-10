import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static boolean[] group;
	static int[][] taste;

	static int bal;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			n = Integer.parseInt(br.readLine());

			group = new boolean[n + 1];
			taste = new int[n + 1][n + 1];
			bal = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++)
					taste[i][j] = Integer.parseInt(st.nextToken());
			}

			int[] ing = new int[n];
			int[] group = new int[2];
			Arrays.fill(ing, n / 2, n, 1);


			do {
				group[0] = group[1] = 0;
				for(int i = 0; i < n; i++) {
					
					for(int j = i+1; j < n; j++) {
						
						if(ing[i] == ing[j])
							group[ing[i]] += taste[i][j] + taste[j][i];
					}
				}
				
				if(Math.abs(group[0]-group[1]) < bal)
					bal = Math.abs(group[0]-group[1]);
			} while (np(ing));

			System.out.printf("#%d %d\n",tc,bal);
		}
	}

	public static boolean np(int[] p) {

		int i = p.length - 1;

		while (i > 1 && p[i-1] >= p[i]) // 팀 A, B의 경우의 수는 대칭이니 0까지 할 필요가 없음
			i--;

		if (i == 1)
			return false;

		int j = p.length - 1;
		
		while(p[i-1] >= p[j]) j--;
		
		int temp = p[j];
		p[j] = p[i-1];
		p[i-1] = temp;
		
		
		int k = p.length - 1;
		
		while(i < k) {
			temp = p[i];
			p[i] = p[k];
			p[k] = temp;
			i++; k--;
		}
		
		return true;

	}

}
