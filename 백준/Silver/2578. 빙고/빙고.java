import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[][] vis;

	public static void main(String[] args) throws IOException {

		int[][] board = new int[5][5];
		vis = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int bingo = 0;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());

				for (int a = 0; a < 5; a++) {
					for (int b = 0; b < 5; b++) {
						if (board[a][b] == num) {
							vis[a][b] = true;
						}
					}
				}
//				System.out.println(num + " :: *********");
//				for(int a = 0; a < 5; a++)
//					System.out.println(Arrays.toString(vis[a]));
//				System.out.println(chkbingo() + " : bingo");
				if(chkbingo() >= 3) {
					System.out.println(i*5 + j + 1);
					return;
				}
					

			}
		}

	}

	private static int chkbingo() {
		int bcnt = 0;
		boolean bflag;

		for (int i = 0; i < 5; i++) {
			bflag = true;
			for (int j = 0; j < 5; j++) {
				if (!vis[i][j]) {
					bflag = false;
					break;
				}
			}
			if (bflag)
				bcnt++;
		}
		
		for (int i = 0; i < 5; i++) {
			bflag = true;
			for (int j = 0; j < 5; j++) {
				if (!vis[j][i]) {
					bflag = false;
					break;
				}
			}
			if (bflag)
				bcnt++;
		}
		bflag = true;
		for (int i = 0; i < 5; i++) {
	
			if (!vis[i][i]) {
				bflag = false;
				break;
			}
		}
		if (bflag)
			bcnt++;
		
		bflag = true;
		for (int i = 0; i < 5; i++) {
			bflag = true;
			if (!vis[4-i][i]) {
				bflag = false;
				break;
			}
		}
		if (bflag)
			bcnt++;

		return bcnt;
	}

}
