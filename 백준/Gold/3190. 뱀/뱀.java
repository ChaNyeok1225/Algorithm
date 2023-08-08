import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// 뱀 이동을 위한 dx, dy
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		// 보드 크기 n
		int n = Integer.parseInt(br.readLine());
		// 사과 개수
		int k = Integer.parseInt(br.readLine());

		// 사과 좌표 입력
		int[][] board = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			board[x][y] = -1; // 보드 값이 -1이면 사과로 표시
		}
		board[0][0] = 1; // 뱀이 있는 곳은 1로 표시
		
		int sdir = 1; // 뱀의 시작방향은 오른쪽 (dx[1], dy[1])

		// 명령어 입력
		int l = Integer.parseInt(br.readLine());
		int[][] com = new int[l][2];
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			com[i][0] = Integer.parseInt(st.nextToken()); // 명령어의 입력 시간
			com[i][1] = st.nextToken().equals("D") ? 1 : -1; // 우회전 좌회전 
		}

		// 진행 시간을 나타내는 sec, 명령어 진행도를 나타내는 idx
		int sec = 0, idx = 0;
		int x = 0, y = 0; // 뱀 머리 좌표
		int[] tail = new int[2]; // 뱀 꼬리 생성
		
		LinkedList<int[]> point = new LinkedList<>(); // 꼬리가 따라갈 좌표를 저장할 큐
		while (true) {
			sec++; // 시간 증가
			
			// 뱀 이동
			int nx = x + dx[sdir]; 
			int ny = y + dy[sdir];

			// 이동 좌표 저장
			point.add(new int[]{nx,ny});

			// 뱀의 진행을 볼 수 있는 출력
//			for(int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(board[i]));
//			System.out.println();
			
			// 뱀이 벽에 부딪치거나 자기의 몸(보드 1)에 부딪치면 종료
			if (nx < 0 || ny < 0 || n <= nx || n <= ny)
				break;
			if (board[nx][ny] == 1)
				break;

			// 이동하는 보드가 사과(-1)이 아니라면
			// 꼬리가 있던 부분을 0(뱀이 없는 곳)으로 만들고 저장했던 좌표로 꼬리를 이동
			if (board[nx][ny] != -1) {
				board[tail[0]][tail[1]] = 0;
				tail = point.pop().clone();
			}
			
			// 뱀의 머리가 이동한 곳은 1로 변경
			board[nx][ny] = 1;
			// 현재 뱀의 머리 좌표 변경
			x = nx; y = ny;

			// 명령어 실행
			if (idx < l) // 명령어가 남아있다면
				if (com[idx][0] == sec) // 현재 시간과 명령어 실행 시간이 같다면
					sdir = (4 + sdir + com[idx++][1]) % 4; // 회전
		}

		System.out.println(sec);
	}

}
