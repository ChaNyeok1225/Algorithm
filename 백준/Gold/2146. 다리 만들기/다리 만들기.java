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

		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = st.nextToken().charAt(0) - '0';
			}
		}

		LinkedList<int[]> q = new LinkedList<>();
		int code = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1) {
					code++;
					board[i][j] = code;
					q.add(new int[] { i, j });
				}

				while (!q.isEmpty()) {
					int[] p = q.pop();

					for (int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];

						if (nx < 0 || ny < 0 || n <= nx || n <= ny)
							continue;

						if (board[nx][ny] != 1)
							continue;

						board[nx][ny] = code;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}

		int[][] dist = new int[n][n];

		int ans = 999999;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != 0) {
					q.add(new int[] {i,j});
					dist[i][j] = 0;
					
					L : while(!q.isEmpty()) {
						int[] p = q.pop();
						
						for(int dir = 0; dir < 4; dir++) {
							int nx = p[0] + dx[dir];
							int ny = p[1] + dy[dir];
							
							if(nx < 0 || ny < 0 || n <= nx || n <= ny)
								continue;
							if(dist[nx][ny] >= 0 || (board[i][j] == board[nx][ny]))
								continue;
							
							if(board[nx][ny] != 0 && board[i][j] != board[nx][ny]) {
								ans = Math.min(ans, dist[p[0]][p[1]]);
								q.clear();
								break L;
							}
							
							dist[nx][ny] = dist[p[0]][p[1]] + 1;
							q.add(new int[] {nx,ny});
						}
					}
					for(int k = 0; k < n; k++)
						Arrays.fill(dist[k], -1);
				}
			}
		}

//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(board[i]));
//		System.out.println();
//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(dist[i]));
		
		System.out.println(ans);
		
		////////////////////////////////////////////////////
		br.close();
	}

}
