import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] player;
	static int[] seq = new int[10];
	static boolean[] sel = new boolean[10];
	static int n;
	static int maxscore;

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		player = new int[n + 1][10];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++)
				player[i][j] = Integer.parseInt(st.nextToken());
		}

		sel[1] = true;
		seq[4] = 1;
		dfs(1);

		System.out.println(maxscore);

	}

	static void dfs(int cnt) {

		if (cnt == 10) {
			int idx = 1;
			int score = 0;

			for (int i = 1; i <= n; i++) {
				int zerocnt = 0;
				int get = 0;
				int hit;
				int[] base = new int[3];

				while (true) {
					hit = player[i][seq[idx]];
					idx = (idx % 9) + 1;

					if (hit == 0)
						zerocnt++;
					else if (hit == 4) {
						get += base[0] + base[1] + base[2] + 1;
						base[0] = base[1] = base[2] = 0;
					} else if (hit == 3) {
						get += base[0] + base[1] + base[2];
						base[0] = base[1] = base[2] = 0;
						base[2] = 1;
					} else if (hit == 2) {
						get += base[1] + base[2];
						base[2] = base[0];
						base[1] = 1;
						base[0] = 0;
					} else {
						get += base[2];
						base[2] = base[1];
						base[1] = base[0];
						base[0] = 1;
					}

					if (zerocnt == 3) {
						score += get;
						break;
					}
				}
			}

			if (maxscore < score)
				maxscore = score;

			return;
		}
		if (cnt == 4)
			dfs(cnt + 1);
		else {
			for (int i = 1; i < 10; i++) {
				if (sel[i])
					continue;
				seq[cnt] = i;
				sel[i] = true;
				dfs(cnt + 1);
				sel[i] = false;
			}
		}

	}

}