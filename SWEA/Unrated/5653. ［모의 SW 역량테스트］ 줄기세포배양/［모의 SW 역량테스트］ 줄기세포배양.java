import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static final int SIZE = 400;
	static int[][] board, time;
	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
	static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			board = new int[SIZE][SIZE];
			time = new int[SIZE][SIZE];
			boolean[][] chk = new boolean[SIZE][SIZE];
			int cnt = 0;
			
			pq.clear();
			
			for (int i = SIZE/2; i < SIZE/2 + n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = SIZE/2; j < SIZE/2 + m; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					
					if (board[i][j] != 0) {
						time[i][j] = 1;
						pq.offer(new int[] { i, j, board[i][j], board[i][j] });
						if(2*board[i][j] > k && !chk[i][j]) {
							chk[i][j] = true;
							cnt++;
						}
					}
				}
			}
			int sec = 0;

			while (sec <= k) {
				
				if (pq.peek()[2] >= sec) {
					sec++;
					continue;
				}

				int[] p = pq.poll();
				
				if(board[p[0]][p[1]] != p[3])
					continue;
				
				for (int dir = 0; dir < 4; dir++) {
					int nx = p[0] + dx[dir];
					int ny = p[1] + dy[dir];
					
					if((time[nx][ny] == 0 || time[nx][ny] == sec) && board[nx][ny] < p[3]) {
						board[nx][ny] = p[3];
						time[nx][ny] = sec;
						
						pq.offer(new int[] {nx, ny, sec + p[3], p[3]});
						if(sec + p[3] + p[3] > k && !chk[nx][ny]) {
							chk[nx][ny] = true;
							cnt++;
						}
						
					}
					
				}
			}
			
//			for(int i = 0; i < SIZE; i++)
//				System.out.println(Arrays.toString(chk[i]));
			
			System.out.printf("#%d %d\n",tc, cnt);
		}
	}

}
