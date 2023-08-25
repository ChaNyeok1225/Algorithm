import java.io.*;
import java.util.*;


// SWEA 1767 - 프로세서 연결하기
class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] board; 
	static ArrayList<int[]> processor;
	static int size, min, n, maxconnect;

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine()); // Testcase 횟수 입력
		for (int tc = 1; tc < T + 1; tc++) { // Testcase 만큼 반복

			n = Integer.parseInt(br.readLine()); // 이차원 배열 크기

			board = new int[n][n]; // 배열 생성
			processor = new ArrayList<>(); // 코어 위치를 담을 ArrayList

			for (int i = 0; i < n; i++) { // 배열 입력
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) //가장자리 코어라면 등록안함
						processor.add(new int[] { i, j });
				}
			}
			size = processor.size(); // 수행해야하는 프로세서의 개수
			min = Integer.MAX_VALUE; // min 값 초기화
			maxconnect = -1;         // 연결 개수 초기화
			dfs(0, 0, 0); // 프로세서 인덱스, 전선의 길이, 연결된 코어

			System.out.printf("#%d %d\n", tc, min); // 출력
		}
	}

	private static void dfs(int idx, int sum, int connect) { // 한가지 코어마다 5가지 동작 (상하좌우연결, 또는 연결 안함)

		if (maxconnect < connect) { // 현재 저장해둔 연결 코어보다 연결된 개수가 많다면 값 변경 
			maxconnect = connect;
			min = sum;
		}
		if (maxconnect == connect && min > sum) // 연결 개수는 같지만 전선의 길이가 작다면 값 변경
			min = sum;

		if (idx == size)  // 모든 코어를 확인했다면 return
			return;

		int[] p = processor.get(idx); // 수행할 코어의 위치
		int nx = p[0], ny = p[1], cnt = 0; 
		boolean flag = false; // 코어 활성화 체크 flag
		for (int dir = 0; dir < 4; dir++) {
			flag = false; // 값 초기화
			cnt = 0;
			nx = p[0];
			ny = p[1];
			while (true) { // 전선 새기는 작업
				nx += dx[dir];
				ny += dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || n <= ny) { // 전기에 닿았다면 flag = true 하고 break
					flag = true;
					break;
				}
				if (board[nx][ny] != 0) // 전기에 닿지 못헀다면 break
					break;

				board[nx][ny] = idx + 2; // 전선을 idx + 2로 board에 저장
				cnt++; // 길이 증가
			}

			if (flag) // 전기에 닿았다면 다음 단계로
				dfs(idx + 1, sum + cnt, connect + 1);

			nx = p[0];
			ny = p[1];
			while (true) { // 복원
				nx += dx[dir];
				ny += dy[dir];

				if (nx < 0 || ny < 0 || n <= nx || n <= ny)
					break;

				if (board[nx][ny] == idx + 2) { // board가 idx+2라면 0으로
					board[nx][ny] = 0;
				} else
					break;
			}
		}
		dfs(idx+1, sum, connect); // 연결하지 않고 다음 단계로
	}

}
