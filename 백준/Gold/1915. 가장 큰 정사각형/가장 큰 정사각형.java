import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n + 1][m + 1];
		int[][] D = new int[n + 1][m + 1];

		int max = 0;
		for (int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = ch[j] - '0';
				D[i][j] = board[i][j];
				if(board[i][j] > 0)
					max = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (board[i][j] > 0) {
					D[i][j] = min(D[i][j-1], D[i-1][j],D[i-1][j-1]) + 1;
					if(max < D[i][j])
						max = D[i][j];
				}
			}
		}
		System.out.println(max*max);
	}

	static int min(int... num) {
		int a = Integer.MAX_VALUE;
		for(int i = 0; i < num.length; i++)
			if(num[i] < a)
				a= num[i];
		return a;
	}
}
