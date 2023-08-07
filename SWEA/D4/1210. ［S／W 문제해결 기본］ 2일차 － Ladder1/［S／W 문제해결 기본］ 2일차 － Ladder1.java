import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String args[]) throws Exception {
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			int[] end = new int[2];

			int[][] board = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int num = Integer.parseInt(st.nextToken());
					board[i][j] = num;
					if (num == 2) {
						end[0] = i;
						end[1] = j;
					}
				}
			}

			boolean flag = true;
			int[] dy = { -1, 1 };
			int x = end[0];
			int y = end[1];
			while (true) {
				flag=true;
				x -= 1;
				
				if (x == 0)
					break;
				
				
				
				for (int dir = 0; dir < 2 && flag; dir++) {
					while (true) {
						if (y + dy[dir] < 0 || y + dy[dir] >= 100)
							break;
						if (board[x][y + dy[dir]] != 1)
							break;

						y += dy[dir];
						flag=false;
					}
					
				}

			}
			System.out.printf("#%d %d\n", n, y);

		}
	}
}
