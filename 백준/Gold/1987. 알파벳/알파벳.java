import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int max, r, c;				// 결과값 max, 행 크기, 열 크기
	static int[] dx = { 1, 0, -1, 0 };	// 말의 진행 방향
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] alpha = new boolean[26]; // 알파벳의 등장을 체크할 ㅂ열
	static char[][] board;				// 보드를 입력받을 배열
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine()); // 배열 크기 입력
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][];			// 보드 생성

		for (int i = 0; i < r; i++) {	// 보드 입력
			board[i] = br.readLine().toCharArray();
		}

		alpha[board[0][0]-'A'] = true;	// 처음 말의 위치에 적혀있는 알파벳 true로 설정
		
		dfs(0,0,1);						// dfs
		
		System.out.println(max);		// 답 출력

	}

	static void dfs(int x, int y, int cnt) {
		if(max < cnt)		// 최장거리라면
			max = cnt;		// 답으로 설정
		
		
		for(int dir = 0; dir < 4; dir++) {	// 4방 탐색
			int nx = x + dx[dir];	// 다음 좌표
			int ny = y + dy[dir];
			
			if(nx < 0 || ny < 0 || r <= nx || c <= ny) // 배열을 벗어나면 continue
				continue;
			if(alpha[board[nx][ny]-'A'])	// 이미 밟았던 알파벳이면 continue
				continue;
			
			alpha[board[nx][ny]-'A'] = true;	// 다음에 존재하는 알파벳 true
			dfs(nx,ny,cnt + 1);					// dfs 진행
			alpha[board[nx][ny]-'A'] = false;	// 복원
		}
		

	}

}
