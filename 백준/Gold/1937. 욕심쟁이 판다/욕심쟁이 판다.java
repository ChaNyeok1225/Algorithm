import java.io.*;
import java.util.*;

//start	2023. 12. 18  18 : 17
//end 	2023. 12. 18  18 : 46
public class Main {
	
	static int[][] dis, board;
	static int ans, n;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dis = new int[n][n]; // 경로 길이를 저장할 배열
		ans = 0;

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (dis[i][j] != 0) // 이미 저장된 값이 있으면 continue;
					continue;
				dfs(i, j); // 경로 길이 탐색
				ans = ans > dis[i][j] ? ans : dis[i][j]; // 결과값 초기화
			}
		}

		System.out.println(ans); // 출력
	}
	
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 }; // 4방탐색
	
	static int dfs(int x, int y) {
		int value = 1; // 기본 값 1
		
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			// 인덱스 범위 및 대나무 조건 확인
			if(valid(nx, ny) || board[nx][ny] <= board[x][y]) 
				continue;
			
			if(dis[nx][ny] != 0) { // 이미 저장된 값이 있으면 해당 값 + 1로 max
				value = value > dis[nx][ny] + 1 ? value : dis[nx][ny] + 1;
			} else { // 저장된 값이 없다면 탐색
				int ret = dfs(nx,ny);
				value = value > ret + 1? value : ret + 1;
			}
		}
		
		return dis[x][y] = value; // 배열에 값 저장
	}
	
	static boolean valid(int x, int y) {
		return x < 0 || y < 0 || x >= n || y >= n;
	}

}