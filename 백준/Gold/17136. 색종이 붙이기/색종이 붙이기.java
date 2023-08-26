import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] board = new int[10][10];
	static int[][] vis = new int[10][10];
	static int[] least = { 0, 5, 5, 5, 5, 5 };
	static int oneCnt, min = Integer.MAX_VALUE, ss;
	static ArrayList<int[]> One = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());

				if (board[i][j] == 1) {
					One.add(new int[] { i, j });
					oneCnt++;
				}
			}
		}

		dfs(0, 0, 0);

		if (min == Integer.MAX_VALUE)
			min = -1;

		System.out.println(min);
	}

	static void dfs(int idx, int cnt, int fill) {
//		System.out.println(min + " *******" + oneCnt + " : " + fill + Arrays.toString(least));
//		for(int i = 0; i < 10; i++) 
//			System.out.println(Arrays.toString(vis[i]));
		
		if(cnt > min)
			return;
		
		if (fill == oneCnt) {
			if (min > cnt) {
				min = cnt;
			}
			return;
		}

		if(idx == One.size())
			return;
		

		int[] p = One.get(idx);

		if (vis[p[0]][p[1]] > 0) {
			dfs(idx+1, cnt, fill);
			return;
		}

		boolean flag = true, tflag = true;
		for (int k = 5; k > 0; k--) {
			flag = true;
			L1 : for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					int x = p[0] + i;
					int y = p[1] + j;

					if (9 < x || 9 < y || board[x][y] == 0 || vis[x][y] != 0) {
						flag = false;
						break L1;
					}

					vis[x][y] = idx+1;
				}
			}

			if (flag) {
				if (least[k] > 0) {
					tflag = false;
					least[k]--;
					dfs(idx + 1, cnt + 1, fill + k * k);
					least[k]++;
				}
			}

			L2: for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					int x = p[0] + i;
					int y = p[1] + j;

					if (9 < x || 9 < y || board[x][y] == 0 || vis[x][y] != idx+1) {
						flag = false;
						break L2;
					}
					if (vis[x][y] == idx+1)
						vis[x][y] = 0;
				}
			}
		}
		
		if(tflag)
			return;

	}

}
