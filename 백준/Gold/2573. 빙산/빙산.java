import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		int[][] cntZero = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;
		int year = 0;
		L: while (true) {
			boolean flag = false;
			boolean[][] vis = new boolean[n][m];
			LinkedList<int[]> q = new LinkedList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (vis[i][j] == false && board[i][j] > 0) {
						if (flag) {
							res = year;
							break L;
						}
						
						q.add(new int[] { i, j });
						vis[i][j] = true;
						flag = true;

						while (!q.isEmpty()) {
							int[] p = q.pop();

							for (int dir = 0; dir < 4; dir++) {
								int nx = p[0] + dx[dir];
								int ny = p[1] + dy[dir];

								if (nx < 0 || ny < 0 || n <= nx || m <= ny)
									continue;
								if (vis[nx][ny] == true || board[nx][ny] <= 0)
									continue;

								vis[nx][ny] = true;
								q.add(new int[] { nx, ny });
							}
						}
					}
				}
			}
			
			if(!flag)
				break;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					int cnt = 0;
					if(board[i][j] > 0) {
						for(int dir = 0; dir < 4; dir++) {
							int nx = i + dx[dir];
							int ny = j + dy[dir];
							
							if (nx < 0 || ny < 0 || n <= nx || m <= ny)
								continue;
							if(board[nx][ny] <= 0)
								cnt++;
						}
						
						cntZero[i][j] = cnt;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(board[i][j] > 0)
						board[i][j] -= cntZero[i][j];
				}
			}
			year++;
		}
		
		System.out.println(res);

		////////////////////////////////////////////////////
		br.close();
	}

}
