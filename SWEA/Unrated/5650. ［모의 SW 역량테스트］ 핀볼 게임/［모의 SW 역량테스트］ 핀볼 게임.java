import java.io.*;
import java.util.*;

public class Solution {

	static int n, max; 
	static int sp[], board[][], dx[] = { -1, 0, 1, 0, 0 }, dy[] = { 0, 1, 0, -1, 0 };
	static HashMap<Integer, int[]> hm;

	static int[][] block = {{}, {4, 4, 1, 0}, {1, 4, 4, 2}, {3, 2, 4, 4}, {4, 0, 3, 4}, {4,4,4,4}};
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < T + 1; tc++) {

			n = Integer.parseInt(br.readLine().trim());

			board = new int[n][n];
			hm = new HashMap<>();
			max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

					if (board[i][j] >= 6) {
						if (hm.containsKey(board[i][j])) {
							board[i][j] = -board[i][j];
							hm.put(board[i][j], new int[] { i, j });
						} else {
							hm.put(board[i][j], new int[] { i, j });
						}
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] == 0) {
						for(int dir = 0; dir < 4; dir++) {
							move(i, j, dir, 0, i, j, false);
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, max);

		}

	}

	private static void move(int x, int y, int dir, int cnt, int sx, int sy, boolean flag) {
		if(x==sx && y == sy && flag) {
			if(max < cnt)
				max = cnt;
			return;
		}
		
		if(dir == 4) {
			if(max < cnt * 2 - 1)
				max = cnt * 2- 1;
			return;
		}
		if(x < 0 || y < 0 || n <= x || n <= y) {
			if(max < cnt * 2 + 1)
				max = cnt * 2 + 1;
			return;
		}
		if(board[x][y] == -1) {
			if(max < cnt)
				max = cnt;
			return;
		}
		
		if(board[x][y] == 0) {
			move(x + dx[dir], y + dy[dir], dir, cnt, sx, sy, true);
		} else if( 0 < board[x][y] && board[x][y] < 6) {
			dir = block[board[x][y]][dir];
			move(x + dx[dir], y + dy[dir], dir, cnt+1, sx, sy, true);
		} else if(Math.abs(board[x][y]) > 5) {
			int[] np = hm.get(-board[x][y]);
			move(np[0] + dx[dir],np[1] + dy[dir], dir, cnt, sx, sy, true);
		}
		
	}

}
