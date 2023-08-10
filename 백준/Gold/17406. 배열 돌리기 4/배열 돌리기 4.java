import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		// 1. input
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] board = new int[n+1][m+1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < m + 1; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][] rot = new int[k][4];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			rot[i][0] = i;
			for (int j = 1; j < 4; j++)
				rot[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		int sum;

		do {
			int[][] tmp = new int[n + 1][m + 1];

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++)
					tmp[i][j] = board[i][j];
			}
			
			for (int i = 0; i < k; i++) 
				move(rot[i], tmp);

			
			for(int i = 1; i < n + 1; i++) {
				sum = 0;
				for(int j = 1; j < m + 1; j++)
					sum += tmp[i][j];
				
				if(sum < min)
					min = sum;
			}
			
		} while (np(rot));
		
		System.out.println(min);

	}

	private static void move(int[] ins, int[][] tmp) {

		int get, x, y;

		for (int run = 1; run < ins[3] + 1; run++) {
//			System.out.println(run);
			x = ins[1] - run;
			y = ins[2] - run;
			get = tmp[x][y];

			for (int dir = 0; dir < 4; dir++) {
				for (int i = 0; i < run * 2; i++) {
//					System.out.println(x + ", " + y + " = " + (x+dx[dir]) + ", " + (y+dy[dir]));
					
					tmp[x][y] = tmp[x+dx[dir]][y+dy[dir]];
					x += dx[dir];
					y += dy[dir];
				}
			}
			
			tmp[x][y+1] = get;

		}

	}

	private static boolean np(int[][] rot) {

		int i = rot.length - 1;

		while (i > 0 && rot[i - 1][0] >= rot[i][0])
			i--;

		if (i == 0)
			return false;

		int j = rot.length - 1;

		while (rot[i - 1][0] >= rot[j][0])
			j--;

		int[] tmp = rot[i - 1].clone();
		rot[i - 1] = rot[j];
		rot[j] = tmp;

		int k = rot.length - 1;

		while (i < k) {
			tmp = rot[i].clone();
			rot[i] = rot[k];
			rot[k] = tmp;
			i++;
			k--;
		}

		return true;
	}

}
