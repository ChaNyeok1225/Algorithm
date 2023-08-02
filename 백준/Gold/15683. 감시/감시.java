import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int m;

	static int[][] board = new int[10][10];
	static int[][] copy = new int[10][10];

	static List<int[]> cctv = new ArrayList<>();

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int num;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				num = Integer.parseInt(st.nextToken());
				board[i][j] = num;

				if (num != 0 && num != 6) {
					cctv.add(new int[] { i, j });
				}
			}
		}

		// 몇개의 조합이 있는가?
		// 1번은 4, 2번은 2, 3번은 4, 4번은 4, 5번은 1의 경우의 수를 가진다.
		// 1번 cctv가 8개 있다면 4^8의 경우의 수가 될 것.
		// 하지만 각 cctv마다 경우의 수를 다르게 센다면 예외처리가 복잡해지므로
		// 모든 cctv의 경우의 수를 4로 생각한다.

		// 조합의 경우의 수 : 4 ^ list.size() # cctv의 갯수

		// << k 연산은 값을 2^k 해주는 것과 같기 때문에 << 2 * k 는 4^k와 같다
		int end = 1 << (2 * cctv.size());

		int combt = 0;
		int dir = 0;
		int cctvcase = 0;
		int[] p;
		int cnt;
		int min = n*m;
		for (int comb = 0; comb < end; comb++) {
			cnt = 0;
			// board copy
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					copy[i][j] = board[i][j];

			combt = comb;

			for (int i = 0; i < cctv.size(); i++) {
				dir = combt % 4;
				combt /= 4;
				p = cctv.get(i);
				cctvcase = copy[p[0]][p[1]];

				switch (cctvcase) {
				case 1:
					observe(p[0], p[1], dir);
					break;

				case 2:
					// 반대 방향 확인
					observe(p[0], p[1], dir);
					observe(p[0], p[1], dir + 2);
					break;

				case 3:
					// 직각 방향 확인
					observe(p[0], p[1], dir);
					observe(p[0], p[1], dir + 1);
					break;

				case 4:
					// 3 방향 확인
					observe(p[0], p[1], dir);
					observe(p[0], p[1], dir + 1);
					observe(p[0], p[1], dir + 2);
					break;

				case 5:
					observe(p[0], p[1], dir);
					observe(p[0], p[1], dir + 1);
					observe(p[0], p[1], dir + 2);
					observe(p[0], p[1], dir + 3);
					break;
				}
			}
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					if(copy[i][j] == 0)
						cnt++;
			
			if(min > cnt)
				min = cnt;
			
		}
		
		
		System.out.println(min);
	}

	static void observe(int x, int y, int dir) {
		dir %= 4;
		int nx = x;
		int ny = y;
		while (true) {
			nx += dx[dir];
			ny += dy[dir];

			if (nx < 0 || ny < 0 || n <= nx || m <= ny)
				break;

			if (copy[nx][ny] == 6)
				break;

			if (copy[nx][ny] == 0)
				copy[nx][ny] = 7; // 입력에서 제시한 0~6까지와는 다른 수
			else
				continue; // cctv나 이미 칠한 곳이면 다음 칸 확인.
		}
	}

}
