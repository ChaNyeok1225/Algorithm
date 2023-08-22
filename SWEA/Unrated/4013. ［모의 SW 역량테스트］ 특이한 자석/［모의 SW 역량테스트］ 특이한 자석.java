import java.io.*;
import java.util.*;

/*
 * BOJ 14891 톱니바퀴
 * 
 * 구현
 * 각 톱니바퀴마다 배열 생성
 * 각 톱니바퀴마다 다른 톱니바퀴와 닿는 부분의 인덱스를 저장
 * 1번 - 2
 * 2번 - 6, 2
 * 3번 - 6, 2
 * 4번 - 6
 * 
 * 톱니바퀴를 돌리기 전에 맞닿은 부분이 같은지 확인하고 회전 
 * (시계방향이면 인덱스 -1, 반시계면 1, 배열의 크기를 넘어서면 인덱스 값 초기화
 * 맞닿은 부분이 같은 톱니바퀴에 대해 재 실행
 * 
 */

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// 좌, 우 탐색
	static int[] dx = { -1, 1 };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			int k = Integer.parseInt(br.readLine());
			
			// 톱니바퀴 배열, 1 = true, 0 = false로 저장
			boolean[][] wheels = new boolean[5][8];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheels[i][j] = st.nextToken().equals("1") ? true : false;
				}
			}

			// 현재 다른 톱니바퀴들과 맞닿은 부분의 인덱스
			// 0은 왼쪽 톱니바퀴, 1은 오른쪽 톱니바퀴
			int[][] chkidx = new int[5][2];
			for (int i = 1; i <= 4; i++) {
				chkidx[i][0] = 6;
				chkidx[i][1] = 2;
			}

			// 회전할 톱니바퀴를 담을 큐
			LinkedList<int[]> q = new LinkedList<>();

			// t번 실행
			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());

				// 돌아가는 톱니바퀴의 번호와 방향
				int selW = Integer.parseInt(st.nextToken());
				int rot = Integer.parseInt(st.nextToken());

				// 탐색을 진행하며 방문 처리
				boolean[] vis = new boolean[5];

				// 큐에 삽입하고 방문 처리
				q.add(new int[] { selW, rot });
				vis[selW] = true;

				// 큐가 빌 때까지
				while (!q.isEmpty()) {
					int[] p = q.pop();

					// 좌, 우 확인
					for (int dir = 0; dir < 2; dir++) {
						int nx = p[0] + dx[dir];

						// 1~4번이 아니면 continue;
						if (nx < 1 || 4 < nx || vis[nx])
							continue;

						// 맞닿은 부분의 값이 다르면 (극이 다르면) 큐에 삽입
						if (wheels[nx][chkidx[nx][1 - dir]] != wheels[p[0]][chkidx[p[0]][dir]])
							q.add(new int[] { nx, 0 - p[1] });

						// 방문 처리
						vis[nx] = true;
					}

					// 회전 방향이 -1(반시계)이면 인덱스 증가, += -(-1)
					// 회전 방향이 1(시계)이면 인덱스 감소, += -(1)
					chkidx[p[0]][0] += -(p[1]);
					chkidx[p[0]][1] += -(p[1]);

					// 인덱스 크기 초기화
					if (chkidx[p[0]][0] < 0)
						chkidx[p[0]][0] += 8;
					if (chkidx[p[0]][1] < 0)
						chkidx[p[0]][1] += 8;

					if (chkidx[p[0]][0] > 7)
						chkidx[p[0]][0] -= 8;
					if (chkidx[p[0]][1] > 7)
						chkidx[p[0]][1] -= 8;
				}

			}

			// 오른쪽 맞닿은 부분(3시방향)의 인덱스에서 -2 하면 12시방향
			int score = 0;

			for (int i = 1; i <= 4; i++) {
				int top = chkidx[i][1] - 2;
				if (top < 0)
					top += 8;

				if (wheels[i][top])
					score += 1 << (i - 1);

			}

			System.out.printf("#%d %d\n",tc, score);
		}
	}

}
