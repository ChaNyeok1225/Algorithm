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
		int[][][] D = new int[n + 1][m + 1][3];

		for (int i = 1; i < n + 1; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 1; j < m + 1; j++) {
				board[i][j] = ch[j - 1] - '0';
				if (board[i][j] != 0) {
					D[i][j][0] = 1;
					D[i][j][1] = 1;
					D[i][j][2] = 1;
				}
			}
		}

		int max = 0;
		for (int i = 1; i < n + 1; i++) {

			for (int j = 1; j < m + 1; j++) {
				if (D[i][j][0] > 0) {
					int size = 1000;
					if (D[i - 1][j][0] > 0)
						D[i][j][0] += D[i - 1][j][0];
					if (D[i][j - 1][1] > 0)
						D[i][j][1] += D[i][j - 1][1];
					if(D[i-1][j-1][2] > 0)
						D[i][j][2] += min(D[i-1][j-1][0], D[i-1][j-1][1],D[i-1][j-1][2]);
					
					size = min(D[i][j][0],D[i][j][1],D[i][j][2]);
					
					if(max < size)
						max = size;
				}
			}
		}

//		for (int i = 0; i < n + 1; i++) {
//			for (int j = 0; j < m + 1; j++)
//				System.out.print(Arrays.toString(D[i][j]) + " ");
//			System.out.println();
//		}
		
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
