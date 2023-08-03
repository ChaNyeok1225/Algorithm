import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			board[x][y] = -1;
		}
		board[0][0] = 1;
		int sdir = 1;

		int l = Integer.parseInt(br.readLine());
		int[][] com = new int[l][2];

		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			com[i][0] = Integer.parseInt(st.nextToken());
			com[i][1] = st.nextToken().equals("D") ? 1 : -1;
		}

		int sec = 0, idx = 0;
		int x = 0, y = 0;
		int[] tail = new int[2];
		
		LinkedList<int[]> point = new LinkedList<>();
		while (true) {
			sec++;
			
			int nx = x + dx[sdir];
			int ny = y + dy[sdir];

			point.add(new int[]{nx,ny});

//			for(int i = 0; i < n; i++)
//				System.out.println(Arrays.toString(board[i]));
//			System.out.println();
			
			if (nx < 0 || ny < 0 || n <= nx || n <= ny)
				break;
			if (board[nx][ny] == 1)
				break;

			if (board[nx][ny] != -1) {
				board[tail[0]][tail[1]] = 0;
				tail = point.pop().clone();
			}
			
			board[nx][ny] = 1;
			x = nx; y = ny;

			if (idx < l)
				if (com[idx][0] == sec)
					sdir = (4 + sdir + com[idx++][1]) % 4;
		}

		System.out.println(sec);
	}

}
