import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[][] board = new char[12][6];
	static boolean[][] puyo = new boolean[12][6];

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int n = 12;
	static int m = 6;

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				board[i][j] = c[j];
				if (c[j] != '.')
					puyo[i][j] = true;
			}
		}

		// 연쇄 진행도
		int cnt = 0;

		while (true) {

			// 보드를 탐색하여 터트리는 메소드
			if (burstChk()) {

				// 아래로 내리는 메소드
				boardSort();

//				for(int i = 0; i < n; i++)
//					System.out.println(Arrays.toString(board[i]));
//				for(int i = 0; i < n; i++)
//					System.out.println(Arrays.toString(puyo[i]));
//				System.out.println("******************************");

				// 연쇄 진행 증가
				cnt++;

			} else { // 아무것도 터트리지 못했다면 반복문 탈출
				break;
			}

		}

		System.out.println(cnt);
	}

	private static void boardSort() {

		for (int i = 0; i < m; i++) {
			int ground = n - 1;
			for (int j = n - 2; j >= 0; j--) {
				if (puyo[j][i]) {
					for (int k = ground; k > j; k--) {
						ground--;
						if(!puyo[k][i]) {
							puyo[k][i] = true;
							board[k][i] = board[j][i];
							
							board[j][i] = '.';
							puyo[j][i] = false;

							break;
						}
					}
				}
			}
		}

	}

	private static boolean burstChk() {
		boolean flag = false;

		LinkedList<int[]> q = new LinkedList<>();
		List<int[]> plist = new ArrayList<>();

		int pn = 0; // 붙어있는 뿌요의 개수
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (puyo[i][j]) {
					q.add(new int[] { i, j });
					plist.add(new int[] { i, j });
					pn = 1;

					puyo[i][j] = false;
				}

				while (!q.isEmpty()) {
					int[] p = q.pop();

					for (int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];

						if (nx < 0 || ny < 0 || n <= nx || m <= ny)
							continue;
						if (!puyo[nx][ny] || board[p[0]][p[1]] != board[nx][ny])
							continue;

						q.add(new int[] { nx, ny });
						plist.add(new int[] { nx, ny });

						puyo[nx][ny] = false;
						pn++;
					}
				}

				if (pn >= 4) {
					flag = true;

					for (int k = plist.size() - pn; k < plist.size(); k++) {
						int[] p = plist.get(k);
						board[p[0]][p[1]] = '.';
					}
					plist = plist.subList(0, plist.size() - pn);

					pn = 0;
				}
			}
		}

		for (int i = 0; i < plist.size(); i++) {
			int[] p = plist.get(i);
			puyo[p[0]][p[1]] = true;
		}

		return flag;
	}

}

/*
 * BOJ 11559 Puyo Puyo
 * 
 * 구현 기능 1. 터트리는 기능 (boolean , 하나라도 터트리면 true, 못터트리면 false) - board를 탐색하며 bfs로
 * 터트림 (4개 이상이라면) - bfs에 사용할 q - list에 q의 좌표들을 넣고 bfs를 마쳤을때 cnt가 4이상이면 - list에
 * 좌표들을 탐색하며 해당 board의 인덱스를 . 으로 변경
 * 
 * 2. 터트리는 기능이 true를 반환하면 아래로 내리는 기능 - board의 아래부터 열 우선 탐색을 진행하며 아래로 내림
 * 
 * 시간 복잡도 계산  (부정확)
 * 12 * 6 (board 탐색) + 12 * 6 (board 값 변경) + 12 * 6 * 2 (boardsort)
 * 
 */