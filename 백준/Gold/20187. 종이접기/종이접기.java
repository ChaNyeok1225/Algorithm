import java.io.*;
import java.util.*;

public class Main {

	static int[][] paper, part;
	static char[] met;
	static int n, m, x, y, x2, y2;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; // 버퍼리더로 받은 입력을 나누기 위한 스트링토크나이저 생성

		int k = Integer.parseInt(br.readLine()); // k 입력

		n = 1; // 종이의 크기를 구하기 위한 변수
		for (int i = 0; i < k; i++) // k번 반복
			n *= 2; // 크기는 2^k

		m = 2 * k; // 접는 방법의 개수

		paper = new int[n][n]; // n*n 크기의 종이
		part = new int[2][2]; // 2*2의 부분 종이
		met = new char[m]; // 접는 방법을 담는 배열

		st = new StringTokenizer(br.readLine()); // 방법 입력
		for (int i = 0; i < m; i++) // m번 반복
			met[i] = st.nextToken().charAt(0); // 입력

		getP(0, n, n); // 접었을 때 정사각형 x y 좌표

		paper[x][y] = Integer.parseInt(br.readLine()); // part위치에 구멍

		sethole(m - 1, 1, 1);

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				sb.append(paper[i][j] + " ");
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void sethole(int idx, int h, int w) {
		
		if (idx == -1) {
			return;
		}
		
		
		switch (met[idx]) { // 각 방법에 따라 시작점 변경
		case 'D':

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					paper[x - 1 - i][y + j] = (paper[x + i][y + j] + 2) % 4;
				}
			}

			x -= h;
			h *= 2;
			break;

		case 'R':

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					paper[x + i][y - 1 - j] = (paper[x + i][y + j] ^ 1);
				}
			}

			y -= w;
			w *= 2;
			break;

		case 'U':

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					paper[x + 1 - i][y + j] = (paper[x + i][y + j] + 2) % 4;
				}
			}

			h *= 2;
			break;

		case 'L':

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					paper[x + i][y + 1 - j] = (paper[x + i][y + j] ^ 1);
				}
			}

			w *= 2;
			break;
		}

		sethole(idx - 1, h, w);
	}

	static void getP(int idx, int h, int w) { // 시작점 찾기
		
		if (idx == m) { // 방법이 끝나면 리턴
			return;
		}

		switch (met[idx]) { // 각 방법에 따라 시작점 변경
		case 'D':
			x += h / 2;
			h /= 2;
			break;

		case 'R':
			y += w / 2;
			w /= 2;
			break;

		case 'U':
			h /= 2;
			break;

		case 'L':
			w /= 2;
			break;
		}

		getP(idx + 1, h, w);

	}

}
