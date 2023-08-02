import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n, max;
	static int[][][] board = new int[20][20][2];
	static int[][][] tboard = new int[20][20][2];

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				board[i][j][0] = v;
				if (v > max)
					max = v;
			}
		}

		int noc = 1 << (2 * 5);
		for (int c = 0; c < noc; c++) {
			int tmp = c;

			tboard = new int[n][n][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					tboard[i][j] = board[i][j].clone();
			}

//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++)
//					System.out.print(tboard[i][j][0] + " ");
//				System.out.println();
//			}
//			System.out.println("*************************");

			for (int move = 0; move < 5; move++) {

				moveBlock(tmp % 4);
//				System.out.println(tmp%4 + "in");
				
				tmp /= 4;
				
//				for(int i = 0; i < n; i++) {
//					for(int j = 0; j < n; j++) 
//						System.out.print(tboard[i][j][0] + " ");
//					System.out.println();
//				} System.out.println("*************************");
			}

		}

		System.out.println(max);

		br.close();
	}

	private static void moveBlock(int dir) {
		// 0 위, 1 오른, 2 아래, 3 왼

		switch (dir) {
		case 0:
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n; j++) {
					for (int k = j - 1; k >= 0; k--) {
						int[] num = tboard[k+1][i].clone();
						int[] tnum = tboard[k][i];
						
						if (tnum[0] == 0) {
							tboard[k][i] = num;
							tboard[k+1][i][0] = 0;
						} else if (num[1] == 0 && tnum[1] == 0 && tnum[0] == num[0]) {
							tboard[k][i][0] <<= 1;
							tboard[k][i][1] = 1;
							tboard[k+1][i][0] = 0;

							if (tboard[k][i][0] > max)
								max = tboard[k][i][0];
							break;
						} else {
							break;
						}
					}
				}
			}

			break;

		case 1:
			for (int i = 0; i < n; i++) {
				for (int j = n - 2; j >= 0; j--) {

					for (int k = j + 1; k < n; k++) {
						int[] num = tboard[i][k-1].clone();
						int[] tnum = tboard[i][k];

						if (tnum[0] == 0) {
							tboard[i][k] = num;
							tboard[i][k-1][0] = 0;
						} else if (num[1] == 0 && tnum[1] == 0 && tnum[0] == num[0]) {
							tboard[i][k][0] <<= 1;
							tboard[i][k][1] = 1;
							tboard[i][k-1][0] = 0;
							
							if (tboard[i][k][0] > max)
								max = tboard[i][k][0];
							break;
						}else {
							break;
						}
					}
				}
			}

			break;

		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = n - 2; j >= 0; j--) {
					for (int k = j + 1; k < n; k++) {
						int[] num = tboard[k-1][i].clone();
						int[] tnum = tboard[k][i];

						if (tnum[0] == 0) {
							tboard[k][i] = num;
							tboard[k-1][i][0] = 0;
						} else if (num[1] == 0 && tnum[1] == 0 && tnum[0] == num[0]) {
							tboard[k][i][0] <<= 1;
							tboard[k][i][1] = 1;
							tboard[k-1][i][0] = 0;
							
							if (tboard[k][i][0] > max)
								max = tboard[k][i][0];
							break;
						}else {
							break;
						}
					}
				}
			}

			break;

		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < n; j++) {

					for (int k = j - 1; k >= 0; k--) {
						int[] num = tboard[i][k+1].clone();
						int[] tnum = tboard[i][k];

						if (tnum[0] == 0) {
							tboard[i][k] = num;
							tboard[i][k+1][0] = 0;
						} else if (num[1] == 0 && tnum[1] == 0 && tnum[0] == num[0]) {
							tboard[i][k][0] <<= 1;
							tboard[i][k][1] = 1;
							tboard[i][k+1][0] = 0;
							
							if (tboard[i][k][0] > max)
								max = tboard[i][k][0];
							break;
						}else {
							break;
						}
					}
				}
			}

			break;
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				tboard[i][j][1] = 0;

	}

}

// BOJ 12100 2048 (Easy)

// 구현 주의사항
// 1. 같은 숫자가 있으면 << 1 연산
// 2. 이미 한번 합쳐진 블록은 다시 합쳐지지 않음
// 3. 위쪽으로 이동시킬땐 위쪽에 있는 블록들이 우선적으로 합쳐짐

// 필요한 변수
// board[4][4][2] 값 , 상태

// 구현 기능
// 방향을 인자로 받아서 (4방향) 해당 방향으로 움직이는 기능
// 값이 같고 상태가 false면 합치는 기능

// 시간 복잡도 계산
// 4^5 (이동의 경우의 수) * 20 * 20 * 5 ?
////////////////////// 구현부/////////////////////////
