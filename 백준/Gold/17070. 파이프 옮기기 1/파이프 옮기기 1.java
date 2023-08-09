import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		boolean[][] vis = new boolean[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				vis[i][j] = st.nextToken().equals("1") ? true : false;
			}
		}

		int[][][] D = new int[n + 1][n + 1][3];
		D[1][1][0] = 1;
		
		for(int i = 2; i < n + 1; i++) {
			if(vis[1][i]) break;
			D[1][i][0] = 1;
		}

		// 0 가로, 1 세로, 2 대각선
		for (int i = 2; i < n + 1; i++) {
			for (int j = 3; j < n + 1; j++) {

				if (!vis[i][j]) {
					D[i][j][0] = D[i][j - 1][0] + D[i][j - 1][2];
					D[i][j][1] = D[i - 1][j][1] + D[i - 1][j][2];
					if (!vis[i][j - 1] && !vis[i - 1][j])
						D[i][j][2] = D[i - 1][j - 1][0] + D[i - 1][j - 1][1] + D[i - 1][j - 1][2];
				}

			}
		}

//		for (int i = 0; i < n + 1; i++) {
//			for (int j = 0; j < n + 1; j++) {
//				System.out.print(Arrays.toString(D[i][j]) + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(D[n][n][0] + D[n][n][1] + D[n][n][2]);

	}

}