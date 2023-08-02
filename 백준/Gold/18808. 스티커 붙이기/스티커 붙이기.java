import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[][] notebook = new boolean[45][45];
	static boolean[][] sticker = new boolean[10][10];

	static int n, m, r, c;

	public static void main(String[] args) throws IOException {

		// 필요한 기능, 붙이기 체크 메소드, 붙이는 메소드, 회전 메소드

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		while (k-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			for(int i = 0; i < r; i++)
				Arrays.fill(sticker[i], false);
			
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					sticker[i][j] = st.nextToken().equals("1") ? true : false;
				}
			}

			L : for (int rot = 0; rot < 4; rot++) {

				for (int i = 0; i < n - r + 1; i++) {
					for (int j = 0; j < m - c + 1; j++) {
						if(attachCheck(i, j)) {
							attach(i,j); 
							break L;
						}
					}
				}
				
				if(rot == 3)
					break;
				
				rotate();
				
				int t = r;
				r = c;
				c = t;

			}

		}
		
		int cntT = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(notebook[i][j])
					cntT++;
		
		System.out.println(cntT);
		

		br.close();
	}

	static boolean attachCheck(int x, int y) {

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j] && notebook[x + i][y + j])
					return false;
			}
		}

		return true;
	}

	static void attach(int x, int y) {

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (sticker[i][j])
					notebook[x + i][y + j] = true;
			}
		}

	}

	static void rotate() {

		boolean[][] tmp = new boolean[c][r];
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				tmp[i][j] = sticker[r-1-j][i];
			}
		}
		
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				sticker[i][j] = tmp[i][j];
			}
		}
		
	}

}
