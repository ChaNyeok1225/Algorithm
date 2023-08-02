import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;

	static int[][] board = new int[55][55];
	static int[] ck;

	static List<int[]> home = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();

	static int min;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ck = new int[m];

		int num;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				num = Integer.parseInt(st.nextToken());
				board[i][j] = num;
				if (num == 1)
					home.add(new int[] { i, j });
				else if (num == 2)
					chicken.add(new int[] { i, j });
			}
		}

		min = 9999999;

		comb(0, 0);

		System.out.println(min);
	}

	static void comb(int idx, int r) {
		if (r == m) {
			dist();
			return;
		}
		for (int i = idx; i < chicken.size(); i++) {
			ck[r] = i;
			comb(i + 1, r + 1);
		}
	}

	static void dist() {
		int dist = 0;
		int[] ckp;
		int[] hp;
		
		int s;
		int d;
		for(int i = 0; i < home.size(); i++) {
			hp = home.get(i);
			s = 99999;
			for(int j = 0; j < m; j++) {
				ckp = chicken.get(ck[j]);
				
				d = Math.abs(hp[0] - ckp[0]) + Math.abs(hp[1] - ckp[1]);
				
				if(s > d)
					s = d;
			}
			
			dist += s;
		}
		
		if(min > dist)
			min = dist;

	}

}
