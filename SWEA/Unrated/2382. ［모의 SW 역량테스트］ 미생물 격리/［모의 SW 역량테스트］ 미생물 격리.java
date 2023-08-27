import java.io.*;
import java.util.*;

class Solution {

	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] board = new int[n][n];
			int[][] tmp = new int[n][n];
			HashMap<Integer, int[]> hm = new HashMap<>();
			hm.put(0,new int[] {0,0,0,0});
			for (int i = 1; i < k + 1; i++) {

				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int nums = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				board[x][y] = i;
				hm.put(i, new int[] { x, y, nums, dir - 1, nums });
			}

//			System.out.println(0 + " :: --");
//			for(int i = 0 ; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					System.out.printf("%5d",hm.get(board[i][j])[2]);
//				}
//				System.out.println();
//			}
			
			for (int sec = 0; sec < m; sec++) {

				
				for (int i = 0; i < n; i++)
					Arrays.fill(tmp[i], 0);

				for (int cell = 1; cell < k + 1; cell++) {
					if (!hm.containsKey(cell))
						continue;
					int[] c = hm.get(cell);

					c[0] += dx[c[3]];
					c[1] += dy[c[3]];

					if (c[0] < 1 || c[1] < 1 || n - 1 <= c[0] || n - 1 <= c[1]) {
						c[2] /= 2;
						c[4] /= 2;
						c[3] ^= 1;

						if (c[2] == 0) {
							hm.remove(cell);
							continue;
						}
					}

					if (tmp[c[0]][c[1]] != 0) {
						int[] ac = hm.get(tmp[c[0]][c[1]]);

						if (ac[4] > c[4]) {
							ac[2] += c[2];
							hm.remove(cell);
						} else {
							c[2] += ac[2];
							hm.remove(tmp[c[0]][c[1]]);
							tmp[c[0]][c[1]] = cell;
						}

					} else
						tmp[c[0]][c[1]] = cell;

				}

				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++)
						board[i][j] = tmp[i][j];
				
				for(int i = 1; i < k +1; i++) {
					if(hm.containsKey(i)) {
						int[] c= hm.get(i);
						c[4] = c[2];
					}
				}
				
//				System.out.println(sec+1 + " :: --");
//				for(int i = 0 ; i < n; i++) {
//					for(int j = 0; j < n; j++) {
//						System.out.printf("%5d",hm.get(board[i][j])[2]);
//					}
//					System.out.println();
//				}
				
			}

			int total = 0;
			for (int i = 1; i < k + 1; i++)
				if (hm.containsKey(i)) {
//					System.out.println(Arrays.toString(hm.get(i)));
					total += hm.get(i)[2];
				}

			System.out.printf("#%d %d\n", tc, total);
		}

	}
}
